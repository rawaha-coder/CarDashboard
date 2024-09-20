/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/11/24, 5:48 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/11/24, 5:48 PM
 */

package com.automobilegt.cardashboard.ui.screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.automobilegt.cardashboard.ui.theme.GreenSecondaryLight
import com.automobilegt.cardashboard.ui.theme.OnGreenLight
import com.automobilegt.cardashboard.ui.theme.Purple40
import com.automobilegt.cardashboard.ui.theme.PurpleLeft
import com.automobilegt.cardashboard.ui.theme.PurpleRight
import com.automobilegt.domain.entity.WarningLight


@Composable
fun WarningLightScreenBody(
    warningLight: WarningLight
){
    var showDescription by rememberSaveable { mutableStateOf(false) }
    Column (
        Modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    PurpleLeft,
                    PurpleRight
                )
            )
        )
    ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    )
                    .clickable {
                        showDescription = !showDescription
                    }
                    .background(OnGreenLight)
            ) {
                Box(modifier = Modifier
                    .size(52.dp),
                    contentAlignment = Alignment.Center
                ){
                    WarningLightSymbol(warningLight.icon)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = warningLight.name,
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .height(52.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                )
            }

        AnimatedVisibility(
            visible = showDescription,
            enter = fadeIn(),
            exit = fadeOut()
        ){
            Column {
                Text(
                    text = warningLight.description,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(1.dp))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        modifier = Modifier
                            .padding(24.dp)
                            .clickable {

                            },
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun WarningLightSymbol(imageUrl: String){
    AsyncImage(model = imageUrl,
        contentDescription = "Warning light symbol",
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp))
}