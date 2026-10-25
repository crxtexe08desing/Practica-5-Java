# Ejercicio 9 - Auditoria Red Team y reversing de un validador de acceso

Alcance: **solo** la clase ficticia `LoginValidator.java` de la guia, compilada y analizada localmente. Sin sistemas, redes ni cuentas reales.

## Compilar y ejecutar
```
javac LoginValidator.java LoginValidatorSeguro.java Main.java
java Main
javap -c -p LoginValidator.class
```
Version de Java usada: OpenJDK 21. (`javap` tambien se puede ejecutar con `java -m jdk.jdeps/com.sun.tools.javap.Main -c -p -constants -cp . LoginValidator`.)

## 1. Revision del codigo fuente (antes de usar IA)
Datos sensibles y decisiones de autenticacion observadas:
- Usuario `admin` y hash MD5 codificados como constantes `static final`.
- Contrasena verificada con MD5 sin sal.
- `getBytes()` sin codificacion explicita.
- `catch (Exception e) { return ""; }` oculta errores.
- Comparaciones con `equals` (no es tiempo constante) y sin limite de intentos.

**Hipotesis inicial:** las constantes de tipo `String` quedan en el *constant pool* del `.class`, asi que usuario y hash seran legibles sin ejecutar el programa.

## 2. Evidencia local (`javap`)
Comandos: `javac LoginValidator.java` y `javap -c -p -constants LoginValidator.class`. Fragmentos relevantes de la salida:
```
private static final java.lang.String USER = "admin";
private static final java.lang.String PASSWORD_HASH = "5f4dcc3b5aa765d61d8327deb882cf99";
...
  5: ldc  #13   // String admin
 14: ldc  #21   // String 5f4dcc3b5aa765d61d8327deb882cf99
  0: ldc  #23   // String MD5
  8: invokevirtual ... String.getBytes:()[B
```
Hipotesis confirmada: no hace falta decompilar; `javap` ya muestra usuario, hash y el algoritmo.

## 3. Respuestas a las preguntas de analisis
1. **Usuario y hash:** `admin` y `5f4dcc3b5aa765d61d8327deb882cf99`.
2. **`javap` vs decompilador:** `javap` muestra constantes, firmas y bytecode (`ldc`, `invokevirtual`...). Un decompilador (CFR, JD-GUI) reconstruye codigo Java casi identico al fuente, incluidos nombres de metodos y la logica de `login`.
3. **Por que se encuentran los valores:** un `.class` conserva las constantes de cadena en claro; basta con tener el archivo.
4. **Debilidad de MD5:** es rapido (permite probar muchisimas claves por segundo), no usa sal (mismo hash para la misma clave, vulnerable a tablas precalculadas) y tiene colisiones conocidas. Comprobacion local: `printf 'password' | md5sum` da exactamente ese hash, es decir, corresponde a una clave extremadamente comun; con MD5 sin sal, buscar un hash asi es trivial.
5. **`getBytes()`:** usa la codificacion por defecto de la plataforma; con caracteres no ASCII (por ejemplo `ñ`) los bytes, y por tanto el hash, pueden diferir entre entornos. Se corrige con `getBytes(StandardCharsets.UTF_8)`.
6. **Cambios que reducen la exposicion:** quitar secretos del codigo (configuracion externa), usar un algoritmo para contrasenas con sal e iteraciones (PBKDF2/BCrypt/Argon2), comparar en tiempo constante y limitar intentos fallidos.
7. **Limitaciones que persisten:** la demo sigue sin persistencia ni registro de eventos, el contador de intentos vive en memoria (se reinicia al reiniciar), no hay MFA, y las variables de entorno/configuracion tampoco son una gestion de secretos completa (pueden filtrarse en procesos, logs o volcados).

## 4. Hallazgos priorizados
| # | Hallazgo | Tipo | Evidencia | Mitigacion |
|---|---|---|---|---|
| 1 | Credenciales codificadas en el codigo | Observado | `javap`: `USER`, `PASSWORD_HASH` | Configuracion externa |
| 2 | MD5 sin sal para contrasenas | Observado | `ldc "MD5"` en bytecode | PBKDF2/BCrypt/Argon2 con sal |
| 3 | Hash de clave muy comun | Observado | `md5sum` local | Politica de claves; no reutilizar |
| 4 | Sin limite de intentos | Observado | Ausencia de contador | Bloqueo tras N fallos |
| 5 | `getBytes()` dependiente de plataforma | Observado | `getBytes:()[B` | UTF-8 explicito |
| 6 | Errores silenciados (`return ""`) | Observado | Codigo fuente | Propagar/registrar el error |
| 7 | `equals` no es tiempo constante | Supuesto (riesgo teorico en este contexto local) | Codigo fuente | `MessageDigest.isEqual` |

## 5. Version corregida (didactica)
`LoginValidatorSeguro.java`: sin usuario ni hash en el codigo (se pasan por configuracion), PBKDF2WithHmacSHA256 con sal aleatoria y 120 000 iteraciones, UTF-8 explicito, comparacion en tiempo constante, bloqueo tras 3 intentos fallidos y `char[]` para la clave. `Main.java` muestra login correcto, 3 fallos, bloqueo y rechazo posterior. **No es un sistema real de autenticacion.**

## 6. Prompt usado con el modelo y comparacion con IA
> **COMPLETAR:** pega aqui tu prompt (punto de partida de la guia: "Revisa esta clase Java para una auditoria autorizada en un laboratorio local. Prioriza hallazgos que puedan justificarse con el codigo o con la inspeccion del .class...").

**Comparacion entre tu analisis y la IA (COMPLETAR):** anota que hallazgos propuso la IA que tu no habias visto, cuales verificaste con el codigo/`javap` y cuales descartaste o marcaste como supuestos.

## Reto opcional (comparacion de bytecode)
Ejecuta `javap -c -p -constants LoginValidatorSeguro.class`: ya no aparecen `"admin"` ni el hash MD5 como constantes. Solo quedan nombres de algoritmos (`PBKDF2WithHmacSHA256`). Aun asi, ocultar una cadena no equivale a almacenar contrasenas de forma segura; el secreto pasa a la configuracion y hereda sus propios riesgos.

## Extension creativa
Ninguna declarada.
