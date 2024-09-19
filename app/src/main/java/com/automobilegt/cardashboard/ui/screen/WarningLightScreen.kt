/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:09 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:09 PM
 */

package com.automobilegt.cardashboard.ui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.automobilegt.cardashboard.ui.screen.components.WarningLightScreenBody
import com.automobilegt.cardashboard.ui.theme.GreenPrimaryLight
import com.automobilegt.cardashboard.ui.theme.GreenSecondaryLight
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel


@Composable
fun WarningLightScreen(
    navController: NavHostController,
    viewModel: WarningLightViewModel
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    GreenPrimaryLight,
                    GreenSecondaryLight
                )
            )
        )
    ){

        val warningLightsState = viewModel.warningLights.collectAsState()

        Column {
            Spacer(modifier = Modifier.height(52.dp))

            warningLightsState.value.data?.let { warningLights ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
                )
                {
                    items(warningLights) { warningLight ->
                        WarningLightScreenBody(warningLight)
                    }
                }
            }
        }

    }

}