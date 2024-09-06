/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 12:15 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 12:15 PM
 */

package com.automobilegt.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//import androidx.room.Entity
//import androidx.room.PrimaryKey


@Entity(tableName = "warning_light_table")
data class WarningLight(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val severity: String,
    val description: String,
    val code: String,
    val advice: String,
    val icon: String,
    val bookmark: Boolean = false
)