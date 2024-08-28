/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 12:20 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 12:20 PM
 */

package com.automobilegt.domain.repository

import com.automobilegt.domain.entity.WarningLight
import com.automobilegt.domain.utils.DataResource
import kotlinx.coroutines.flow.Flow

interface WarningLightRepository {

    suspend fun getWarningLights(): Flow<DataResource<List<WarningLight>>>

    suspend fun updateBookmark(id: Int, isBookmarked: Boolean)
}
