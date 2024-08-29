/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/28/24, 2:50 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/28/24, 2:50 PM
 */

package com.automobilegt.data.di

import com.automobilegt.data.remote.ApiConstants
import com.automobilegt.data.remote.WarningLightsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//@InstallIn(SingletonComponent::class)
//@Module
//object NetworkModule {
//
//    @Provides
//    @Singleton
//    fun providesRetrofit(): Retrofit{
//        return Retrofit.Builder()
//            .baseUrl(ApiConstants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Provides
//    fun providesWarningLightApi(retrofit: Retrofit):WarningLightsApiService{
//        return retrofit.create(WarningLightsApiService::class.java)
//    }
//}