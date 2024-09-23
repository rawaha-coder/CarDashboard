/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:53 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:53 PM
 */

package com.automobilegt.cardashboard.ui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.automobilegt.cardashboard.ui.screen.SplashScreen
import com.automobilegt.cardashboard.ui.screen.WarningLightScreen
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel


@Composable
fun WarningLightNavGraph(
    navController: NavHostController,
    viewModel: WarningLightViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.WarningLightScreen.route) {
            WarningLightScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.BookmarkScreen.route){
            //BookmarkWarningLightScreen(navController = navController, viewModel = viewModel)
        }
    }
}