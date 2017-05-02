# Sistemas Ubicuos
Ejercicios tema 2 de prácticas de Sistemas Ubicuos (API Android)
## Activity
### Ejercicio 1
Crea una activity manualmente (al usar el wizard elegir “Add No Activity”, que no añade la activity al manifest y no crea un layout automáticamente),está activity debe imprimir por la consola Logcat el mensaje “Hello World”.
```java
Log.i(“HELLO”, “Hello World”);
```
<p align="center">
<img 
src="https://raw.githubusercontent.com/rodrimmbdev/seu_tema2/master/imgs/exercise_1.png"
alt="Imagen ejercicio 1"
height="200"
/>
</p>

### Ejercicio 2
Crea dos activities (como en el ejercicio 1, crea las activities manuealmente), sin interfaz de usuario. La primera activity (```FirstActivity```) debe llamar a la segunda (```SecondActivity```) esperando de esta un resultado. ```SecondActivity``` debe devolver un resultado con la fecha actual.
Debes imprimir por el logcat varios mensajes:
* Cuando se lance ```FirstActivity```.
* Cuando se lance ```SecondActivity```.
* Cuando entremos en la función ```onActivityResult()```.
* Debes imprimir en ```onActivityResult()``` la fecha que nos a pasado ```SecondActivity```.

<b>NOTA:</b> Para obtener la fecha usa los paquetes: ```java.util.Calendar``` y ```java.text.SimpleDateFormat```

### Contactos
Siguiendo con el concepto del ejercicio anterior de lanzar una activity para obtener un resultado vamos a, en vez de obtener un resultado de activity creada por nosotros, lanzar un intent implicito para solicitar a una activity del sistema que nos devuelva datos de un contacto. 

Una vez tengamos los datos de el contacto los imprimiremos en la consola logcat.

<b>NOTA:</b> Debemos tener contactos en la agenda del movil.

## Service
Antes de empezar ha hacer estos ejercicios hay que haber visto el <a href="https://docs.google.com/presentation/d/1hh3VbOnFx8NcYuah30U32LnCMCho4X4inkUPNziGEq0/edit?usp=sharing">tema 3</a> de interfaces de usuario (<a href="https://github.com/rodrimmbdev/seu_tema3">Ejercicios</a>).
### Ejercicio 3
Vamos a crear una app con una UI que tenga dos botones: “Iniciar servicio” y “Parar servicio”.
 
Cada vez que pulsemos el botón “Iniciar servicio”, llamaremos a un ```ServiceIntent``` que pondrá en cola cada petición. Cada petición al servicio mostrará un ```Toast``` con el número de la petición que se ha lanzado y a los 4 segundos finalizar la petición.

El primer hilo mostrará un texto así: “Petición 1”, el segundo “Petición 2”, etc…

Pulsa el botón “Iniciar servicio” varias veces para que veas que los Toast no se solapan al mostrarse por pantalla y cada 4 segundos se muestra un Toast con el número de la petición 

“Parar servicio” llamara a la función ```stopService()```.


<b>NOTA:</b> Cerrar la app sin pulsar “Parar servicio” y ver que el Service sigue funcionando.
### Ejercicio 4
Vamos a crear una app con una UI que tenga dos botones: “Iniciar servicio” y “Parar servicio”.
 
Cada vez que pulsemos el botón “Iniciar servicio” llamaremos a un ```Service``` que creara un hilo por cada petición (hasta un máximo de dos hilos) en el que se muestre un ```Toast``` con el número del hilo que se ha lanzado y espere 4 segundos.
 
Ejemplo de los mensajes a mostrar: “Hilo 1”, “Hilo 2”, etc…

Pulsa el botón “Iniciar servicio” varias veces para que veas que los Toast se solapan y muestra logs por la consola logcat para que veas que solo se ejecutan las tareas de dos en dos.

“Parar servicio” llamara a la función stopService().


<b>NOTA:</b> Usa la clase de la API de java: ```ExecutorService``` y ```Executors.newFixedThreadPool(int threads)``` para la gestión de los hilos. 