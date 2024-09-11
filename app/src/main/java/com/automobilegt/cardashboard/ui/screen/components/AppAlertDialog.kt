/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/11/24, 6:14 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/11/24, 6:14 PM
 */

package com.automobilegt.cardashboard.ui.screen.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.automobilegt.cardashboard.R
import com.automobilegt.cardashboard.ui.navigation.Screen

@Composable
fun AppAlertDialog(navController: NavHostController) {
    val shouldShowDialog = remember { mutableStateOf(true) }

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
                navController.navigate(Screen.WarningLightScreen.route)
            },
            title = { Text(text = stringResource(id = R.string.alert_dialog_title)) },
            text = { Text(text = stringResource(id = R.string.alert_dialog_text)) },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black)),
                    onClick = {
                        shouldShowDialog.value = false
                        navController.navigate(Screen.WarningLightScreen.route)
                    }) {
                    Text(
                        text = stringResource(id = R.string.confirm),
                        color = Color.White
                    )
                }
            }
        )
    }
}