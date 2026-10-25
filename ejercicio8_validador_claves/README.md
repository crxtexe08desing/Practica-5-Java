# Ejercicio 8 - Validador didactico de claves con revision de IA

> Ejercicio de logica y revision de codigo. **No** es un sistema real de autenticacion ni una politica de seguridad suficiente para cuentas reales. Todas las claves son inventadas.

## Compilar y ejecutar
```
javac *.java
java Main
```

## 1. Analisis previo (antes de usar IA)
El codigo inicial acepta una clave si tiene al menos 8 caracteres **y** contiene la subcadena `"123"`. Problemas: exige una secuencia predecible, acepta `"123aaaaa"`, rechaza claves buenas sin "123", lanza `NullPointerException` con `null`, y acepta espacios.

**Casos de prueba propuestos:** `abcdefgh`, `123`, `12345678`, `abc 123 x`.

**Tres reglas elegidas:**
1. Longitud minima de 8 caracteres.
2. Sin espacios en blanco.
3. Al menos una letra y un digito (evita claves solo numericas o solo alfabeticas).

## 2. Version revisada
`ValidadorClave.java`: separa cada regla en un metodo pequeno (`longitudSuficiente`, `sinEspacios`, `tieneVariedad`) y maneja `null`. El original queda en `ValidadorClaveOriginal.java`.

## 3. Prompt usado con el modelo
> **COMPLETAR:** pega el prompt que enviaste. Prompt de partida de la guia: "Revisa esta clase Java como ejercicio didactico. Primero identifica errores logicos y casos limite; luego sugiere pruebas y una mejora pequena. No afirmes que estas reglas hacen segura una cuenta real. Explica cada sugerencia para que pueda verificarla."

## 4. Sugerencias del modelo y verificacion
**Plantilla**: reemplaza la columna 2 con lo que respondio tu IA, ejecuta cada caso en `Main` y clasifica.

| # | Sugerencia (COMPLETAR) | Verificacion | Clasificacion (util / incorrecta / no aplicable) |
|---|---|---|---|
| 1 | | | |
| 2 | | | |
| 3 | | | |

## Mejora aceptada y sugerencia descartada
**COMPLETAR** con tu caso real. Ejemplo de redaccion: "Acepte manejar `null` porque el original lanzaba `NullPointerException` (comprobado en prueba). Descarte exigir simbolos especiales porque la consigna pide reglas sencillas y mas reglas no demuestran mas aprendizaje."

## Pruebas antes y despues
Las produce `java Main`. En la seccion ANTES, las fallas con `12345678` y `abc 123 x` son esperadas: muestran que el codigo inicial era incorrecto (acepta ambas).

## Reto opcional (hecho)
La validacion esta separada en metodos pequenos sin cambiar el comportamiento esperado, lo que hace `esValida` legible en una linea.

## Extension creativa
Ninguna declarada.
