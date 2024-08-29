/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/28/24, 2:51 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/28/24, 2:51 PM
 */

package com.automobilegt.data.di

import android.content.Context
import androidx.room.Room
import com.automobilegt.data.local.WarningLightDatabase
import com.automobilegt.data.local.WarningLightsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@InstallIn(SingletonComponent::class)
//@Module
//object DatabaseModule {
//
//    @Provides
//    @Singleton
//    fun providesDatabase(@ApplicationContext app: Context): WarningLightDatabase{
//        return Room.databaseBuilder(
//            app,
//            WarningLightDatabase::class.java,
//            "warning_light_database"
//            ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun providesWarningLightDao(db: WarningLightDatabase): WarningLightsDao = db.warningLightsDao()
//}