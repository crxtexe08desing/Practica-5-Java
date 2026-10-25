# Ejercicio 1 - Cuenta digital con reglas de negocio

**Se practica:** clases, atributos privados, constructores, encapsulamiento y condicionales.

## Compilar y ejecutar
```
javac *.java
java Main
```
Version de Java usada: OpenJDK 21 (datos ficticios en todas las pruebas).

## Pruebas realizadas
| # | Prueba | Resultado esperado | Obtenido |
|---|---|---|---|
| 1 | Deposito de 50 | `true`, saldo 150 | `true`, 150.00 |
| 2 | Retiro de 30 | `true`, saldo 120 | `true`, 120.00 |
| 3 | Deposito de -10 (monto no positivo) | `false`, saldo sin cambio | `false`, 120.00 |
| 4 | Retiro de 1000 (fondos insuficientes) | `false`, saldo sin cambio | `false`, 120.00 |
| 5 | Retiro de 0 (extra) | `false` | `false` |

## Decisiones de diseno
Atributos privados; sin setters para el saldo, solo `depositar` y `retirar`, que validan y devuelven `boolean`. El constructor rechaza saldo inicial negativo y datos vacios, asi la cuenta nunca queda en estado invalido. `Main` solo consulta y muestra el estado.

## Extension creativa
Ninguna declarada. (Para solicitar puntaje, describe aqui la categoria Easy/Medium/Hard/Insane, que agregaste, conceptos integrados y como lo probaste.)
