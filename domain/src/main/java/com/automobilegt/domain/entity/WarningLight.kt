/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 12:15 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 12:15 PM
 */

package com.automobilegt.domain.entity

data class WarningLight(
    val advice: String,
    val code: String,
    val description: String,
    val icon: String,
    val id: Int,
    val name: String,
    val severity: String,
    val status: String
)