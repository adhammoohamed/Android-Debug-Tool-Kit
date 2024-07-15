package com.example.logcatscreen.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.navigation.logcatscreen.LOGCAT_SCREEN_ROUTE
import com.example.logcatscreen.screen.LogcatScreen
import com.example.logcatscreen.viewmodel.LogcatViewModel

fun NavGraphBuilder.logcatScreen(navController: NavController, paddingValues: PaddingValues) {
    composable(LOGCAT_SCREEN_ROUTE) {
        val viewModel: LogcatViewModel = hiltViewModel()
        val context = LocalContext.current
        val state by viewModel.appInfo.collectAsState()
        LaunchedEffect(Unit) {
            viewModel.getInstalledApps(context.packageManager)
        }

        LogcatScreen(
            navController = navController,
            paddingValues = paddingValues,
            viewModel = viewModel,
            state = state
        )
    }
}
