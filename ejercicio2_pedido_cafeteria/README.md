# Ejercicio 2 - Pedido de cafeteria

**Se practica:** composicion, arreglos, objetos relacionados y calculo de totales.

## Compilar y ejecutar
```
javac *.java
java Main
```
Version de Java usada: OpenJDK 21 (datos ficticios en todas las pruebas).

## Pruebas realizadas
Pedido con tres productos (Cafe 12.50, Croissant 8.00, Jugo 10.00): subtotal y total 30.50. Un cuarto producto es rechazado (capacidad 3). Un producto con precio 0 lanza `IllegalArgumentException`.

## Decisiones de diseno
`Pedido` guarda `Producto[3]` y recorre el arreglo con un `for`; el total lo calcula el propio pedido (no `Main`). Es **composicion**: los productos existen para formar el pedido y el pedido controla su arreglo; en este diseno no se comparten con otros pedidos. (Si los productos fueran un catalogo reutilizable, seria asociacion/agregacion.)

## Extension creativa
Ninguna declarada. (Para solicitar puntaje, describe aqui la categoria Easy/Medium/Hard/Insane, que agregaste, conceptos integrados y como lo probaste.)
