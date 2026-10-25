# Ejercicio 7 - Revision de codigo con ayuda de IA

**Metodo revisado:** `depositar` / `retirar` de `CuentaDigital` (ejercicio 1).

## Compilar y ejecutar
```
javac *.java
java Main
```

## Prompt utilizado
> **COMPLETAR:** pega aqui el prompt exacto que enviaste a tu herramienta de IA. Sugerencia: "Revisa este metodo Java como ejercicio didactico (codigo sin datos reales). Sugiere cinco casos de prueba y explica por que cada uno podria fallar."

## Sugerencias de la IA y verificacion
La tabla de abajo es una **plantilla**: reemplaza la columna "Sugerencia" con lo que respondio *tu* IA y ejecuta cada caso. Las pruebas de `Main.java` ya cubren estos cinco casos tipicos.

| # | Sugerencia (COMPLETAR con la respuesta real) | Prueba ejecutada | Clasificacion |
|---|---|---|---|
| 1 | Deposito valido | `Main` prueba 1 | correcta / incorrecta / no aplicable |
| 2 | Retiro igual al saldo | `Main` prueba 2 | |
| 3 | Retiro con saldo 0 | `Main` prueba 3 | |
| 4 | Deposito `NaN` | `Main` prueba 4 y reproduccion del defecto | |
| 5 | Deposito infinito | `Main` prueba 5 | |

## Defecto confirmado y correccion
Al ejecutar `Main`, la **version original** acepta `depositar(Double.NaN)`: como `NaN <= 0` es `false`, el monto pasa la validacion y el saldo queda en `NaN`, corrompiendo la cuenta. La **version corregida** valida con `Double.isFinite(monto) && monto > 0`.

## Reto opcional
Pide una segunda revision del cambio y comprueba si las pruebas 4 y 5 distinguen casos limite reales (lo hacen: fallan en la version original).

## Extension creativa
Ninguna declarada.
