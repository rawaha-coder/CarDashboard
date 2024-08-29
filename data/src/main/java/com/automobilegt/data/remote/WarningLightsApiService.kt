/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 1:13 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 1:13 PM
 */

package com.automobilegt.data.remote

import retrofit2.Response
import retrofit2.http.GET


interface WarningLightsApiService {

    @GET("warning_lights.json")
    suspend fun getWarningLights(): Response<List<WarningLightDto>>

}