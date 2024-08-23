# CarDashboard

An Android Clean Architecture app written in Kotlin, using Jetpack Compose, Kotlin Coroutines, and Android Architecture Components, with Hilt for Dependency Injection.

### UI Layer

The UI layer was implemented using:

MVVM with ViewModels exposing UiState that the compose consume. The ViewModel does not know anything about it's consumers.
It exposes a single source of truth as a UiState that the consumers can observe to get the events emitted.


### Domain Layer

The domain layer contains the UseCases that encapsulate a single and very specific task that can be performed. This task is part of the business logic of the application. 


### Data Layer

The data layer implements the repository interface that the domain layer defines. The components in this layer provide a single source of truth for data and hide the origin of the data.


## Clean architecture layers

<p align="center">
    <img src="images/rings.png" alt="cleanrings"/>
</p>

## Architecture overview and rules

<p align="center">
    <img src="![rings](https://github.com/user-attachments/assets/36f59221-701c-4fb7-8543-aeaf8acb3837)" alt="architecture"/>
</p>

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

