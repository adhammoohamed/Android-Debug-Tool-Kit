package com.example.androiddebugtoolkit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.homescreen.HOME_SCREEN_ROUTE
import com.example.home.route.homeScreen
import com.example.logcatscreen.route.logcatScreen

@Composable
fun AndroidDebugToolKitApp(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME_SCREEN_ROUTE) {
        homeScreen(navController, paddingValues)
        logcatScreen(navController, paddingValues)
    }
}