/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 12:26 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 12:26 PM
 */

package com.automobilegt.domain.usecase

import com.automobilegt.domain.entity.WarningLight
import com.automobilegt.domain.repository.WarningLightRepository
import com.automobilegt.domain.utils.DataResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class WarningLightUseCase(
    private val repository: WarningLightRepository
) {

    suspend fun getWarningLights(): Flow<DataResource<List<WarningLight>>> {
        return repository.getWarningLights()
    }

    suspend fun updateBookmark(id: Int, isBookmarked: Boolean) {
        repository.updateBookmark(id, isBookmarked)
    }
}
