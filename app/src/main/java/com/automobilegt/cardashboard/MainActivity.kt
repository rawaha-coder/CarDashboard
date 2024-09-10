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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.automobilegt.cardashboard.ui.theme.CarDashboardTheme
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel
import com.automobilegt.domain.utils.DataResource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WarningLightViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarDashboardTheme(){
                CarDashboardApp(viewModel)
            }
        }
    }
}

@Composable
fun CarDashboardApp(viewModel: WarningLightViewModel) {
        WarningLightScreen(viewModel = viewModel)
}

@Composable
fun WarningLightScreen(
    viewModel: WarningLightViewModel
) {

    val warningLightsState = viewModel.warningLights.collectAsState()
    when (val state = warningLightsState.value){
        is DataResource.Fetching -> {
            Text(text = "Loading...", modifier = Modifier.fillMaxSize())
        }
        is DataResource.Success -> {
            state.data?.let { warningLights ->
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(warningLights) { warningLight ->
                        Column(
                            modifier = Modifier
                                .clickable {
                                    //navController.navigate(Screen.DetailsScreen.createRoute(warningLight.id))
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
            Text(text = "Error: ${state.message}", modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize())
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CarDashboardAppPreview() {

}