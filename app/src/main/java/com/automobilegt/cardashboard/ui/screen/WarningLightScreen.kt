/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:09 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:09 PM
 */

package com.automobilegt.cardashboard.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.automobilegt.cardashboard.ui.screen.components.WarningLightScreenBody
import com.automobilegt.cardashboard.ui.theme.PurpleLeft
import com.automobilegt.cardashboard.ui.theme.PurpleRight
import com.automobilegt.cardashboard.ui.viewmodel.WarningLightViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WarningLightScreen(
    navController: NavHostController,
    viewModel: WarningLightViewModel,
) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = rememberTopAppBarState()
        )

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    PurpleLeft,
                    PurpleRight
                )
            )
        )
    ) {
        Scaffold(
            topBar = {
                TopAppBarContent(scrollBehavior = scrollBehavior)
            },
            bottomBar = {
                BottomAppBarContent()
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MiddleAppContent(viewModel = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
){
    TopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.6f)
        ),
        title = {
            Text(
                text = "Car DashBoard Warning Light",
                color = MaterialTheme.colorScheme.onBackground.copy(0.8f),
                fontWeight = FontWeight.Bold
            )
                },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(28.dp),
                imageVector = Icons.Default.Menu,
                contentDescription = null
            )
        },
        actions = {
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp, end = 24.dp)
                    .size(28.dp),
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }

    )

}

@Composable
fun MiddleAppContent(
    viewModel: WarningLightViewModel
) {
    val warningLightsState = viewModel.warningLights.collectAsState()

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

@Composable
fun BottomAppBarContent(){

}