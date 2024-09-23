/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 11:39 AM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 11:39 AM
 */

package com.automobilegt.cardashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.automobilegt.domain.entity.WarningLight
import com.automobilegt.domain.usecase.WarningLightUseCase
import com.automobilegt.domain.utils.DataResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WarningLightViewModel @Inject constructor(
    private val warningLightUseCase: WarningLightUseCase
): ViewModel() {
    private val _warningLights = MutableStateFlow<DataResource<List<WarningLight>>>(DataResource.Fetching())
    val warningLights: StateFlow<DataResource<List<WarningLight>>> = _warningLights

    init {
        loadWarningLights()
    }

    fun loadWarningLights() {
        viewModelScope.launch {
            warningLightUseCase.getWarningLights().collect(
                _warningLights
            )
        }
    }

    fun updateBookmarkStatus(id: Int, bookmark: Boolean) {
        viewModelScope.launch {
            warningLightUseCase.updateBookmark (id, bookmark)
        }
    }

    fun getBookmarkedWarningLight(){
        viewModelScope.launch {
            warningLightUseCase.getBookmarkedWarningLight().collect(
                _warningLights
            )
        }
    }
}