# Ejercicio 6 - Empleados de una pequena tienda

**Se practica:** herencia, constructores, super, sobrescritura y polimorfismo con arreglos.

## Compilar y ejecutar
```
javac *.java
java Main
```
Version de Java usada: OpenJDK 21 (datos ficticios en todas las pruebas).

## Pruebas realizadas
`Empleado[]` con un empleado por hora (15.0 x 80 h = 1200.00) y uno fijo (1800.00). El ciclo no pregunta el tipo.

## Decisiones de diseno
Se **hereda** nombre, id y getters; **cambia** `calcularPago()`, sobrescrito con `@Override` en cada subclase. Los constructores llaman a `super(nombre, id)`. Un tercer subtipo funcionaria sin tocar el ciclo.

## Extension creativa
Ninguna declarada. (Para solicitar puntaje, describe aqui la categoria Easy/Medium/Hard/Insane, que agregaste, conceptos integrados y como lo probaste.)
