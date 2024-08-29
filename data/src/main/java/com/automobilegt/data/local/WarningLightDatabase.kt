/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/28/24, 2:46 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/28/24, 2:46 PM
 */

package com.automobilegt.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase
import com.automobilegt.domain.entity.WarningLight
import dagger.hilt.android.HiltAndroidApp

@Database(entities = [WarningLight::class], version = 1)
abstract class WarningLightDatabase: RoomDatabase(){
    abstract fun warningLightsDao() : WarningLightsDao
}