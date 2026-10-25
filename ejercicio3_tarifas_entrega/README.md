# Ejercicio 3 - Tarifas de entrega

**Se practica:** herencia, sobrescritura, sobrecarga y polimorfismo dinamico.

## Compilar y ejecutar
```
javac *.java
java Main
```
Version de Java usada: OpenJDK 21 (datos ficticios en todas las pruebas).

## Pruebas realizadas
Bicicleta 4 km: 3.00 + 4*0.8 = 6.20. Automovil 12 km: 8.00 + 12*2.5 = 38.00. Sobrecarga `calcularCosto(0.5)` en el automovil: 38.00 + 12*0.5 = 44.00. El ciclo no usa `if` para el tipo.

## Decisiones de diseno
`Entrega[]` mezcla ambas subclases; `@Override` en `calcularCosto()`. La sobrecarga cambia el numero de parametros (`calcularCosto(double)`).

- **Que determina que metodos puedes llamar:** el tipo estatico de la referencia (`Entrega`).
- **Que implementacion se ejecuta:** el tipo dinamico del objeto real (despacho dinamico).

## Extension creativa
Ninguna declarada. (Para solicitar puntaje, describe aqui la categoria Easy/Medium/Hard/Insane, que agregaste, conceptos integrados y como lo probaste.)
