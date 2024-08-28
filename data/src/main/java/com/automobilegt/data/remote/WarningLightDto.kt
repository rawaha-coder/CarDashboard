/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/27/24, 3:18 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/27/24, 3:18 PM
 */

package com.automobilegt.data.remote

data class WarningLightDto(
    val id: Int,
    val name: String,
    val status: String,
    val severity: String,
    val description: String,
    val code: String,
    val advice: String,
    val icon: String
)