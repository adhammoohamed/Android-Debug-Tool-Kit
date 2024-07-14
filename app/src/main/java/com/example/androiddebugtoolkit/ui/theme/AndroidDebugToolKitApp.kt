package com.example.androiddebugtoolkit.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.logcatscreen.route.LOGCAT_SCREEN_ROUTE
import com.example.logcatscreen.route.logcatScreen

@Composable
fun AndroidDebugToolKitApp(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = LOGCAT_SCREEN_ROUTE) {
        logcatScreen(navController, paddingValues)
    }
}