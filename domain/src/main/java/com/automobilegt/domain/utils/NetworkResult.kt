/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/25/24, 11:25 AM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/25/24, 11:25 AM
 */

package com.automobilegt.domain.utils

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>: NetworkResult<T>()
    class Success<T>(data: T?): NetworkResult<T>(data = data)
    class Error<T>(message: String?): NetworkResult<T>(message = message)
}