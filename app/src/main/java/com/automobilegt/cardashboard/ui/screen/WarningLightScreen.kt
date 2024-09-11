/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:09 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:09 PM
 */

package com.automobilegt.cardashboard.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.automobilegt.cardashboard.ui.screen.components.WarningLightMeaning
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel
import com.automobilegt.domain.utils.DataResource

@Composable
fun WarningLightScreen(
    navController: NavHostController,
    viewModel: WarningLightViewModel
) {
    val warningLightsState = viewModel.warningLights.collectAsState()

    warningLightsState.value.data?.let { warningLights ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 48.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
        )
        {
            items(warningLights) { warningLight ->
                WarningLightMeaning(warningLight)
            }
        }
    }
}