/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/11/24, 5:48 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/11/24, 5:48 PM
 */

package com.automobilegt.cardashboard.ui.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.automobilegt.cardashboard.R
import com.automobilegt.domain.entity.WarningLight

@Composable
fun WarningLightMeaning(
    warningLight: WarningLight,
    modifier: Modifier = Modifier
) {
    Column {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .clickable {},
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.red_240))
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = colorResource(id = R.color.red_240)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(BorderStroke(2.dp, Color.Black))
                    .background(Color.Yellow)
                ){
                    WarningLightSymbol(warningLight.icon)
                }
                Text(
                    text = warningLight.name,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            Text(
                text = warningLight.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun WarningLightSymbol(imageUrl: String){
    AsyncImage(model = imageUrl,
        contentDescription = "Warning light symbol",
        modifier = Modifier.fillMaxSize())
}