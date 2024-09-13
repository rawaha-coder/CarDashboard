# CarDashboard


## Project Info:
CarDashboard is an Android app built to demonstrate the use of Clean Architecture and MVVM, leveraging modern Jetpack Architecture Components such as Jetpack Compose, Kotlin Coroutines, and Hilt for Dependency Injection, all implemented within a three-layered architecture.


### UI Layer

The role of the UI is to display the application data on the screen and also to serve as the primary point of user interaction. Whenever the data changes, either due to user interaction (like pressing a button) or external input (like a network response), the UI should update to reflect those changes. Effectively, the UI is a visual representation of the application state as retrieved from the data layer.


### Domain Layer

The domain layer contains the UseCases that encapsulate a single and very specific task that can be performed. This task is part of the business logic of the application. 


### Data Layer

The data layer implements the repository interface that the domain layer defines. The components in this layer provide a single source of truth for data and hide the origin of the data.


## Clean architecture layers

<p align="center">
    <img src="https://github.com/user-attachments/assets/19a0f686-86cc-4ccc-ad2e-5c80f7a7a533" alt="cleanrings"/>
</p>

## Tech Stack

* Gradle
* Kotlin
* Coroutines
* Jetpack Compose
* Material Design
* Room database
* Retrofit
* Hilt
* Coil


## Libraries Used

* [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)
* [Room](https://developer.android.com/topic/libraries/architecture/room)
* [Retrofit2](https://square.github.io/retrofit/)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)


## Screenshots

To do

### License

See LICENSE file

