# NetflixApp -Android

Clean Architecture - MVVM  - Multi Modulos
En este proyecto se utiliza el patron de presentación MVVM, Jetpack Components y Clean architecture.

## MAD SCORE
https://madscorecard.withgoogle.com/scorecards/3960593/

### Librerias
1) JetPack: 
- ViewModel (https://developer.android.com/topic/libraries/architecture/viewmodel) 
- LiveData (https://developer.android.com/topic/libraries/architecture/livedata) 
- Navigation Component (https://developer.android.com/guide/navigation) (https://developer.android.com/training/data-storage/room) 
- Data Binding (https://developer.android.com/topic/libraries/data-binding) 

2) Otras librerias
- Inyeccion de dependencias con Koin (https://insert-koin.io/)
- Carga de imagenes con Glide (https://bumptech.github.io/glide/)
- Consumo de servicios Retrofit (https://square.github.io/retrofit/)
- Cliente HTTP OkHtt3 (https://square.github.io/okhttp/)

### Requisitos tecnicos
- Administrador de dependencias GDM con Kotlin Gradle DSL (https://docs.gradle.org/current/dsl/index.html)
- Koltin 1.4
- Multi modules project
- Material design
- Clean Architecture

### Modulos
1) app
Modulo encargado de gestionar toda la interfaz de usuario
2) buildSrc
Modulo encargo de gestionar las dependencias de los modulos
3) core
Modulo encargado de contener los archivos compartidos por todos los modulos
4) usescases
Modulo encargado de las orquestar el flujo los flujos de datos relacionados con las entidades y asi cumplir las reglas de negocio requeridas.
5) domain
Modulo encargado de tener todos los modelos del dominio de negocio.
6) hardware
Modulo encargado de interactuar con el hardware del dispositivo.
7) dato
Modulos 

![Diagrama de arquitectura](https://user-images.githubusercontent.com/37455842/104227158-f7e62180-5416-11eb-92b2-a97cf8e3327b.jpeg)

### Patrones de diseño involucrados
1) Patron Handler
2) Patron repository


### Principios y practicas implementadas
1) Principios Solid - Stupid
2) Principio Yagni
3) Principio KISS
4) Modulos con alta cohesion Bajo acoplamiento
5. Principio de menor conocimiento

# Capturas de pantalla
![Screenshot_1610434797](https://user-images.githubusercontent.com/37455842/104280663-48429b00-547a-11eb-90f2-6101b751fdc7.png)
![Screenshot_1610434805](https://user-images.githubusercontent.com/37455842/104280679-4ed11280-547a-11eb-90af-1641a38e6e95.png)
![Screenshot_1610434809](https://user-images.githubusercontent.com/37455842/104280691-5395c680-547a-11eb-86cd-1637c53ab26b.png)
![Screenshot_1610434821](https://user-images.githubusercontent.com/37455842/104280696-555f8a00-547a-11eb-850f-54cc420705a4.png)
![Screenshot_1610434928](https://user-images.githubusercontent.com/37455842/104280712-58f31100-547a-11eb-83a8-fa67f033df82.png)

