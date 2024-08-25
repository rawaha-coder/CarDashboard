/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 1:34 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 1:34 PM
 */

package com.automobilegt.data.repository

import com.automobilegt.data.remote.ApiService
import com.automobilegt.domain.entity.WarningLightsResponse
import com.automobilegt.domain.repository.WarningLightsRepository

class WarningLightRepoImpl(private val apiService: ApiService):WarningLightsRepository {
    override fun getWarningLightFormRemote(): WarningLightsResponse = apiService.getWarningLight()
}