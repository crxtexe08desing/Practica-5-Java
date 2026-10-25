# Ejercicio 4 - Sensores de un invernadero

**Se practica:** clase abstracta, interfaces, herencia y contrato de comportamiento.

## Compilar y ejecutar
```
javac *.java
java Main
```
Version de Java usada: OpenJDK 21 (datos ficticios en todas las pruebas).

## Pruebas realizadas
Dos sensores en `Sensor[]` (temperatura 24.0 y humedad 61.0) leidos en un ciclo; tras `calibrar(-1.5)` la temperatura pasa a 22.5 y la humedad no cambia. `Sensor` no se instancia (abstracta).

## Decisiones de diseno
Clase abstracta `Sensor` para estado y comportamiento compartido (id, ubicacion, `reporte()`); la interfaz `Calibrable` expresa una capacidad que no todos los sensores tienen (solo temperatura la implementa). Agregar un tercer sensor no requiere modificar el ciclo.

## Extension creativa
Ninguna declarada. (Para solicitar puntaje, describe aqui la categoria Easy/Medium/Hard/Insane, que agregaste, conceptos integrados y como lo probaste.)
