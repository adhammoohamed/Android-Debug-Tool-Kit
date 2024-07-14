package com.example.logcatscreen.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.logcatscreen.screen.LogcatScreen

const val LOGCAT_SCREEN_ROUTE = "LogcatScreen"

fun NavGraphBuilder.logcatScreen(navController: NavController, paddingValues: PaddingValues) {
    composable(LOGCAT_SCREEN_ROUTE) {
        LogcatScreen(navController, paddingValues = paddingValues)
    }
}

fun NavController.navigateToLogcatScreen() {
    navigate(LOGCAT_SCREEN_ROUTE)
}