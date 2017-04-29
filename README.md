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
