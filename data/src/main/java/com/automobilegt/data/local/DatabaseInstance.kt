/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/2/24, 10:11 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/2/24, 10:11 PM
 */

package com.automobilegt.data.local

import android.content.Context
import androidx.room.Room

// for test to be deleted
object DatabaseInstance {
    @Volatile
    private var INSTANCE:WarningLightDatabase? = null

    fun getDatabase(context: Context): WarningLightDatabase{
        return INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                WarningLightDatabase::class.java,
                "warning_lights_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}