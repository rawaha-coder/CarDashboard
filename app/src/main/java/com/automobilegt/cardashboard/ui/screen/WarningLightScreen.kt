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
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel
import com.automobilegt.domain.utils.DataResource

@Composable
fun WarningLightScreen(
    navController: NavHostController,
    viewModel: WarningLightViewModel
) {
    val warningLightsState = viewModel.warningLights.collectAsState()

    when (val state = warningLightsState.value) {
        is DataResource.Fetching -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(32.dp))
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

        }
        is DataResource.Success -> {
            state.data?.let { warningLights ->
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(warningLights) { warningLight ->
                        Column(
                            modifier = Modifier
                                .clickable {
                                    //navController.navigate(DetailsScreen.createRoute(warningLight.id))
                                }
                                .padding(16.dp)
                        ) {
                            // Display warning light icon and title
                            Text(text = warningLight.name)
                        }
                    }
                }
            }
        }
        is DataResource.Error -> {
            // Show error message
            Text(text = "Error: ${state.message}", modifier = Modifier.fillMaxSize())
        }
    }
}