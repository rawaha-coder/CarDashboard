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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.automobilegt.cardashboard.ui.theme.CarDashboardTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarDashboardApp()
        }
    }
}

@Composable
fun CarDashboardApp() {
    CarDashboardTheme(){
        Text(text = "Hello Zakariae", modifier = Modifier.padding(50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CarDashboardAppPreview() {

}