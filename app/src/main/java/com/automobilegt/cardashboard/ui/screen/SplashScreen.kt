/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:10 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:10 PM
 */

package com.automobilegt.cardashboard.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.automobilegt.cardashboard.R

@Composable
fun SplashScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "CarDashboard",
                //style = MaterialTheme.typography.h4,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your car's companion for safety",
                //style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(32.dp))
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}