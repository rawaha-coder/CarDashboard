/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/27/24, 12:48 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/27/24, 12:48 PM
 */

package com.automobilegt.data.mapper


import com.automobilegt.data.remote.WarningLightDto
import com.automobilegt.domain.entity.WarningLight

object WarningLightMapper {
    fun mapDtoToDomain(dto: WarningLightDto, isBookmarked: Boolean): WarningLight {
        return WarningLight(
            id = dto.id,
            name = dto.name,
            status = dto.status,
            severity = dto.severity,
            description = dto.description,
            code = dto.code,
            advice = dto.advice,
            icon = dto.icon,
            bookmark = isBookmarked
        )
    }
}

