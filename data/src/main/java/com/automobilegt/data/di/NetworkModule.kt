/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/2/24, 8:17 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/2/24, 8:17 PM
 */

package com.automobilegt.data.di

import com.automobilegt.data.remote.ApiConstants
import com.automobilegt.data.remote.WarningLightsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//@Module
//@InstallIn(SingletonComponent::class)
object NetworkModule {


    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideWarningLightApiService(retrofit: Retrofit): WarningLightsApiService{
        return retrofit.create(WarningLightsApiService::class.java)
    }
}