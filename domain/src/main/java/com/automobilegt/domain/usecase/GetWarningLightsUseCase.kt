/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 12:26 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 12:26 PM
 */

package com.automobilegt.domain.usecase

import com.automobilegt.domain.entity.WarningLightsResponse
import com.automobilegt.domain.repository.WarningLightsRepository
import com.automobilegt.domain.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class GetWarningLightsUseCase(private val warningLightRepository: WarningLightsRepository) {

    operator fun invoke() = flow<NetworkResult<WarningLightsResponse>> {
        emit(NetworkResult.Loading())
        val response = warningLightRepository.getWarningLightFormRemote()
        if (response.isSuccess){
            emit(NetworkResult.Success(data = response.getOrThrow()))
        }else{
            emit(NetworkResult.Error(message = response.exceptionOrNull()?.localizedMessage))
        }
    }.catch {
        emit(NetworkResult.Error(message = it.message.toString()))
    }.flowOn(Dispatchers.IO)
}