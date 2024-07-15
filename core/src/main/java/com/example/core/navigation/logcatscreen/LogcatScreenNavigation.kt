package com.example.core.navigation.logcatscreen

import androidx.navigation.NavController

const val LOGCAT_SCREEN_ROUTE = "LogcatScreen"

fun NavController.navigateToLogcatScreen() {
    navigate(LOGCAT_SCREEN_ROUTE)
}