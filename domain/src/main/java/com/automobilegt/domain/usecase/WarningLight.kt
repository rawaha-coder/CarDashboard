/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/24/24, 12:26 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/24/24, 12:26 PM
 */

package com.automobilegt.domain.usecase

import com.automobilegt.domain.repository.WarningLightRepository

class GetWarningLight(private val warningLightRepository: WarningLightRepository) {
    suspend operator fun invoke() = warningLightRepository.getWarningLightFormRemote()
}