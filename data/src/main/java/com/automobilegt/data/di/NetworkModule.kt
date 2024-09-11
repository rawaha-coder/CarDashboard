/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/2/24, 8:17 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/2/24, 8:17 PM
 */

package com.automobilegt.data.di


import com.automobilegt.data.remote.BASE_URL
import com.automobilegt.data.remote.WarningLightsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWarningLightApiService(retrofit: Retrofit): WarningLightsApiService{
        return retrofit.create(WarningLightsApiService::class.java)
    }
}