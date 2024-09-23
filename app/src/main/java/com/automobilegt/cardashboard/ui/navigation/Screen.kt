/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:49 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:49 PM
 */

package com.automobilegt.cardashboard.ui.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object WarningLightScreen : Screen("warning_light_screen")
}