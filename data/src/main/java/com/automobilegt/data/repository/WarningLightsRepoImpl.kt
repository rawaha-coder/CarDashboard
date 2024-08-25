/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 1:34 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 1:34 PM
 */

package com.automobilegt.data.repository

import com.automobilegt.data.remote.WarningLightsApiService
import com.automobilegt.domain.entity.WarningLightsResponse
import com.automobilegt.domain.repository.WarningLightsRepository

class WarningLightsRepoImpl(private val warningLightsApiService: WarningLightsApiService):WarningLightsRepository {

    override fun getWarningLightFormRemote(): Result<WarningLightsResponse> {
        return try {
            val response = warningLightsApiService.getWarningLight()
            if (response.isSuccessful){
                response.body()?.let {
                    Result.success(it)
                } ?: run { Result.failure(Exception("error occurred")) }
            }else{
                Result.failure(Exception("error occurred"))
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}