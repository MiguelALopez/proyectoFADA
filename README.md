Proyecto Fada
=============
Primer miniproyecto de Fundamentos de Analisis y Diseño de Algoritmos 

## 1. Introducción
El siguiente miniproyecto tiene como objetivo enfrentar a los estudiantes del curso:
* Al análisis de dos problemas reales y uso de los conceptos vistos en clase.
* Utilización de diferentes técnicas de programación para dar diferentes
alternativas de solución a dos problemas

## 2. Comité de supervisión
Una amiga suya que está a cargo de organizar las monitorias en la Universidad del Valle tiene
el siguiente problema:

Hay n estudiantes encargados de diversas monitorias(monitoria de sala,
desarrollo de una aplicación, monitoria académica, etc.) Cada uno de
los estudiantes realiza un único turno en la semana el cual corresponde
a un intervalo continuo de tiempo. Pueden realizarse muchos turnos al mismo tiempo.

Su amiga quiere elegir un subconjunto de los monitores para formar un comité
de supervisión, con los cuales se pueda reunir una vez por semana. Ella considera
que el comité esta completo, si para cada estudiante que no este presente en el
comité, su turno se cruza, aunque sea de forma parcial con el turno de uno de
los estudiantes en el comité. De esta forma, el desempeño de cada monitor
puede ser observado por al menos una persona del comité.

El problema que usted debe resolver es encontrar un comité de supervisión que cuente con
la menor cantidad posible de monitores.

**Ejemplo:** Suponga que n = 3 y los turnos son:

Laura Lunes 16:00 - 20:00

Andres Lunes 18:00 - 22:00

Camilo Lunes 21:00 - 23:00

El comité de supervisión más pequeño posible consiste del monitor Andres, ya que el turno
de Laura y el de Camilo se cruza con el turno de Andres.
<ol>
  <li>Resuelva el problema de seleccionar un comité de supervisión entre los monitores de la
      Universidad del Valle por medio de un algoritmo ingenuo o exhaustivo.</li>
  <li>Resuelva el problema de seleccionar un comité de supervisión entre los monitores de
      la Universidad del Valle por medio de un algoritmo más inteligente en el sentido en que
      no tiene en cuenta todos los posibles comités.</li>
  <li>Teniendo en cuenta que los datos de entrada de los problemas pueden seguir las siguientes
      distribuciones:
      ⋅⋅*  **Distribución Uniforme:** En cada momento del tiempo existe misma probabilidad de tener
       monitores realizando turnos.
      ..* **Distribución Normal:** Existe un momento en el tiempo en el cual la probabilidad de tener
      monitores en turno es mas alta que en otros momentos</li>
  <li>¿En todos los casos funciona claramente mejor el algoritmo más inteligente? Sino, ¿En
      cuáles y por qué?</li>
</ol>  
1. Resuelva el problema de seleccionar un comité de supervisión entre los monitores de la
Universidad del Valle por medio de un algoritmo ingenuo o exhaustivo.
2. Resuelva el problema de seleccionar un comité de supervisión entre los monitores de
la Universidad del Valle por medio de un algoritmo más inteligente en el sentido en que
no tiene en cuenta todos los posibles comités.
3. Teniendo en cuenta que los datos de entrada de los problemas pueden seguir las siguientes
distribuciones:
⋅⋅*  **Distribución Uniforme:** En cada momento del tiempo existe misma probabilidad de tener
 monitores realizando turnos.
..* **Distribución Normal:** Existe un momento en el tiempo en el cual la probabilidad de tener
monitores en turno es mas alta que en otros momentos
4. ¿En todos los casos funciona claramente mejor el algoritmo más inteligente? Sino, ¿En
cuáles y por qué?

### 2.1. Entrada
Su algoritmo va a recibir como entrada un archivo de texto que esta organizado de la
siguiente forma

| n       |       |          |      |
|---------|-------|----------|------|
| nombre1 |  dia1 | hInicio1 | hFin1|
| ...     |       |          |      |
| nombren |  dian | hInicion | hFinn|

Donde la primera linea contiene un numero n que representa la cantidad de monitores y las siguientes
n lineas corresponden a la información de cada monitor, donde se incluye el nombre, el dia en el
cual realiza el turno, la hora de inicio y la hora de finalización del turno.

### 2.2. Salida
Se espera que la saida sea un archivo de texto en el cual la primera linea corresponde al numero c
de monitores que conforman el comité y las siguientes c lineas corresponden a los nombres de los
estudiantes que conforman el comité.

## 3. Planeación del trabajo de un procesador
Se cuenta con un procesador que puede trabajar 24 horas al dá, todos los días. Muchas personas mandan
peticiones para correr tareas diarias en el procesador, sin embargo estas peticiones serán atendidas
 en el día siguiente y deben terminar antes de media noche. Cada tarea llega con un tiempo de 
 inicio y de finalización estrictos. Si la tarea es aceptada para correr en el procesador, esta debe
 realizarse diariamente de corma continua, en el periodo comprendido entre el principio y el final
 de la tarea.
 
Dada una cantidad de tareas diarias n, se deben aceptar la mayor cantidad de tareas de forma que se 
maximice la cantidad de tareas realizadas en el día. Tenga en cuenta que no se puede realizar más de
una tarea al tiempo.

**Ejemplo:** Considere las siguientes tareas:

Tarea1 (18:00 - 6:00)

Tarea2 (21:00 - 4:00)

Tarea3 (3:00 - 14:00)

Tarea4 (13:00 - 13:00)

La solucion óptica seria escoger las tareas 2 y 4 para el día siguiente.
1. Resuelva el problema de seleccionar las tareas a realizar en el procesador por medio de un algoritmo
ingenuo o exhaustivo.
2. Resuelva el problema de seleccionar las tareas a realizar en el procesador por medio de un algoritmo
más inteligente, en el sentido que no analize exhaustivamente todas las posibles formas en que se
podrían organizar las tareas
3. Teniendo en cuenta que los datos de entrada de los dos problemas pueden seguir las siguientes
distribuciones:
..* **Distribución Uniforme:** En cada momento del tiempo existe la misma probabilidad de tener 
solicitudes de tareas diarias.
..* **Distrubucion Normal:** Existe un memento de tiempo en el cual la probabilidad de tener solicitudes
de tareas diarias es mas alta que en otros momentos.
4. ¿En todos los casos funciona claramente mejor el algoritmo más inteligente? Sino, ¿En cuáles y por qué?

### 3.3. Entrada
Se va a recibir como entrada un archivo de texto que esta organizado de la siguiente forma

| n       |       |          |      |
|---------|-------|----------|------|
| nombre1 |  dia1 | hInicio1 | hFin1|
| ...     |       |          |      |
| nombren |  dian | hInicion | hFinn|

Donde la primera linea contiene un numero n que representa la cantidad de tareas y las siguientes n
lineas corresponden a la información de cada una de las tareas, donde se incluye el nombre, la hora
de inicio y la hora de finalización de la tarea.

### 3.2. Salida
Se espera que la salida sea un archivo de texto en el cual la primera linea corresponde al numero c
de tareas que se van a realizar en el procesador y las siguientes c lineas corresponden a los nombres
de las tareas a realizar.

## 4. Análisis
* **Eficiencia en tiempo:** Para cada una de las alternativas deberá calcular la complejidad en tiempo
práctica, teniendo en canta las medidas de tiempo de ejecucion tomadas para diferentes entradas y
diferentes tamaños. Esto implica que debe generar un número grande de ejemplos de pruebas y guardarlas 
en un archivo, para poder probar con las dos alternativas con los mismos datos. También debe comparar
los tiempos tomados por las diferentes alternativas y sacar conclusiones, si es posible