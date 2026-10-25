# Ejercicio 5 - Prestamo de un libro

**Se practica:** encapsulamiento, asociacion entre objetos y colaboracion mediante metodos.

## Compilar y ejecutar
```
javac *.java
java Main
```
Version de Java usada: OpenJDK 21 (datos ficticios en todas las pruebas).

## Pruebas realizadas
Secuencia en `Main`: (1) prestamo valido, (2) repetir el prestamo se rechaza, (3) otro prestamo del mismo libro se rechaza, (4) devolucion valida, (5) segunda devolucion se rechaza.

## Decisiones de diseno
`Libro` protege su disponibilidad; `Prestamo` relaciona `Libro` y `Lector` y delega en `Libro.marcarPrestado()`, que valida. `Main` nunca modifica atributos directamente. Un solo prestamo por ejecucion, sin listas.

## Extension creativa
Ninguna declarada. (Para solicitar puntaje, describe aqui la categoria Easy/Medium/Hard/Insane, que agregaste, conceptos integrados y como lo probaste.)
