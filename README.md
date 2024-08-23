# CarDashboard

An Android Clean Architecture app written in Kotlin, using Jetpack Compose, Kotlin Coroutines, and Android Architecture Components, with Hilt for Dependency Injection.

### UI Layer

The role of the UI is to display the application data on the screen and also to serve as the primary point of user interaction. Whenever the data changes, either due to user interaction (like pressing a button) or external input (like a network response), the UI should update to reflect those changes. Effectively, the UI is a visual representation of the application state as retrieved from the data layer.


### Domain Layer

The domain layer contains the UseCases that encapsulate a single and very specific task that can be performed. This task is part of the business logic of the application. 


### Data Layer

The data layer implements the repository interface that the domain layer defines. The components in this layer provide a single source of truth for data and hide the origin of the data.


## Clean architecture layers

<p align="center">
    <img src="![app-architecture](https://github.com/user-attachments/assets/19a0f686-86cc-4ccc-ad2e-5c80f7a7a533)" alt="cleanrings"/>
</p>


## Architecture overview and rules

to do

## Feature

To do

## Tech Stack

To do


## Libraries Used

To do

## Screenshots

To do

### License

See LICENSE file

