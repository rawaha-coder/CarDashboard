/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/2/24, 7:26 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/2/24, 7:26 PM
 */

package com.automobilegt.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

//    operator fun invoke(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(ApiConstants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : WarningLightsApiService by lazy {
        RetrofitInstance.retrofit.create(WarningLightsApiService::class.java)
    }
}