/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/23/24, 5:57 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/23/24, 1:02 PM
 */

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CarDashboard"
include(":app")
