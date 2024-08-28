/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/27/24, 1:32 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/27/24, 1:32 PM
 */

package com.automobilegt.data.utils

sealed class DatabaseResult<T>(val data: T? = null, val message: String? = null){
    class Fetching<T>: DatabaseResult<T>()
    class Success<T>(data: T?): DatabaseResult<T>(data)
    class Error<T>(message: String?): DatabaseResult<T>(message = message)

}