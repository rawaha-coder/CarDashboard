/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/27/24, 2:50 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/27/24, 2:50 PM
 */

package com.automobilegt.domain.utils

sealed class DataResource<T>(val data: T? = null, val message: String? = null) {
    class Fetching<T>: DataResource<T>()
    class Success<T>(data: T?): DataResource<T>(data = data)
    class Error<T>(message: String?): DataResource<T>(message = message)
}