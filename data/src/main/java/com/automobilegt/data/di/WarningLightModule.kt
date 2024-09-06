/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/6/24, 12:08 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/6/24, 12:08 PM
 */

package com.automobilegt.data.di


import com.automobilegt.data.repository.WarningLightsRepoImpl
import com.automobilegt.domain.repository.WarningLightRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object WarningLightModule {

    @Provides
    fun providesWarningLightRepository(
        warningLightsRepoImpl: WarningLightsRepoImpl
    ): WarningLightRepository {
        return warningLightsRepoImpl
    }
}