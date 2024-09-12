/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 9/10/24, 12:07 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 9/10/24, 12:07 PM
 */

package com.automobilegt.cardashboard

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.request.CachePolicy
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application(), ImageLoaderFactory{
    override fun newImageLoader(): ImageLoader {
        return ImageLoader(this).newBuilder()
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                DiskCache.Builder()
                    .maxSizePercent(0.01)
                    .directory(cacheDir)
                    .build()
            }
            .build()
    }

}
