/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/2/24, 10:02 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/2/24, 10:02 PM
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


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "warning_lights_database"

    @Provides
    @Singleton
    fun provideWarningLightDatabase(
        @ApplicationContext appContext: Context
    ): WarningLightDatabase{
       return Room.databaseBuilder(
           appContext,
           WarningLightDatabase::class.java,
           DATABASE_NAME
            )
           .fallbackToDestructiveMigration()
           .build()
    }

    @Provides
    fun provideWarningLightDao(warningLightDatabase: WarningLightDatabase): WarningLightsDao{
        return warningLightDatabase.warningLightsDao()
    }

}