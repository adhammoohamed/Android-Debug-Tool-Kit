package com.example.home.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.navigation.homescreen.HOME_SCREEN_ROUTE
import com.example.home.screen.HomeScreen


fun NavGraphBuilder.homeScreen(navController: NavController, paddingValues: PaddingValues) {
    composable(HOME_SCREEN_ROUTE) {
        HomeScreen(navController = navController, paddingValues = paddingValues)
    }
}