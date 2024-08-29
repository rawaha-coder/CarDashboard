/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/26/24, 4:47 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/26/24, 4:47 PM
 */

package com.automobilegt.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.automobilegt.domain.entity.WarningLight


@Dao
interface WarningLightsDao {

    @Query("SELECT * FROM warning_light_table")
    suspend fun getAllWarningLights(): List<WarningLight>

    @Query("SELECT * FROM warning_light_table WHERE id = :id LIMIT 1")
    suspend fun getWarningLightById(id: Int): WarningLight?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(warningLights: List<WarningLight>)

    @Query("UPDATE warning_light_table SET bookmark = :isBookmarked WHERE id = :id")
    suspend fun updateBookmark(id: Int, isBookmarked: Boolean)

    @Query("DELETE FROM warning_light_table")
    suspend fun clearAll()

}