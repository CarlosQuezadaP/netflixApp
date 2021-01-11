# NetflixApp -Android

Clean Architecture - MVVM  - Multi Modulos
En este proyecto se utiliza el patron de presentación MVVM, Jetpack Components y Clean architecture.

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

### Patrones de diseño involucrados
1) Patron Handler
2) Patron repository


### Principios y practicas implementadas
1) Principios Solid - Stupid
2) Principio Yagni
3) Principio KISS
4) Modulos con alta cohesion Bajo acoplamiento
5. Principio de menor conocimiento

