/*
 * Project Name CarDashboard
 * Created by Zakariae El Kadiri on 8/23/24, 5:57 PM
 * Copyright (c) 2024 All rights reserved.
 * Last modified 8/23/24, 1:02 PM
 */

package com.automobilegt.cardashboard

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.automobilegt.cardashboard", appContext.packageName)
    }
}