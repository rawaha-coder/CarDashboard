/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/23/24, 5:57 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/23/24, 1:02 PM
 */

package com.automobilegt.cardashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.automobilegt.cardashboard.ui.navigation.WarningLightNavGraph
import com.automobilegt.cardashboard.ui.theme.CarDashboardTheme
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WarningLightViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarDashboardTheme(){
                val navController = rememberNavController()
                WarningLightNavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}


