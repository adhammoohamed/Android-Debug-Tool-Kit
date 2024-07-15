package com.example.core.navigation.homescreen

import androidx.navigation.NavController

const val HOME_SCREEN_ROUTE = "HOME_SCREEN_ROUTE"

fun NavController.navigateToHomeScreen() {
    navigate(HOME_SCREEN_ROUTE)
}