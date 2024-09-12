/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 1:34 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 1:34 PM
 */

package com.automobilegt.data.repository

import com.automobilegt.data.local.WarningLightsDao
import com.automobilegt.data.mapper.WarningLightMapper
import com.automobilegt.data.remote.WarningLightsApiService
import com.automobilegt.domain.entity.WarningLight
import com.automobilegt.domain.repository.WarningLightRepository
import com.automobilegt.domain.utils.DataResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class WarningLightsRepoImpl @Inject constructor(
    private val warningLightsApiService: WarningLightsApiService,
    private val warningLightsDao: WarningLightsDao
) : WarningLightRepository {

    override suspend fun getWarningLights(): Flow<DataResource<List<WarningLight>>> = flow {
        emit(DataResource.Fetching())

        // Fetch cached data
        val cachedData = warningLightsDao.getAllWarningLights()
        if (cachedData.isNotEmpty()) {
            emit(DataResource.Success(cachedData))
        }

        try {
            // Fetch data from remote API
            val response = warningLightsApiService.getWarningLights()
            if (response.isSuccessful) {
                response.body()?.let { listWL ->
                    val entities = listWL.map { dto ->
                        val cachedWarningLight = warningLightsDao.getWarningLightById(dto.id)
                        WarningLightMapper.mapDtoToDomain(
                            dto = dto,
                            isBookmarked = cachedWarningLight?.bookmark ?: false
                        )
                    }
                    // Clear old data and insert new data into the database
                    warningLightsDao.clearAll()
                    warningLightsDao.insertAll(entities)
                    emit(DataResource.Success(entities))
                }
            } else {
                if (cachedData.isEmpty()) {
                    emit(DataResource.Error("Failed to fetch data from Remote, please check internet"))
                }
            }
        } catch (e: Exception) {
            if (cachedData.isEmpty()) {
                emit(DataResource.Error("Error occurred: ${e.message}"))
            }
        }
    }

    override suspend fun updateBookmark(id: Int, isBookmarked: Boolean) {
        warningLightsDao.updateBookmark(id, isBookmarked)
    }
}
