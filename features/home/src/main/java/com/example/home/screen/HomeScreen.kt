package com.example.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.core.navigation.logcatscreen.navigateToLogcatScreen
import com.example.core.ui.VerticalSpacer8Dp


@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {


    HomeScreenContent(
        paddingValues = paddingValues,
        onLogcatClicked = { navController.navigateToLogcatScreen()},
        onMemoryClicked = { /*TODO*/ }) {
        
    }

}

@Composable
fun HomeScreenContent(
    paddingValues: PaddingValues,
    onLogcatClicked: () -> Unit,
    onMemoryClicked: () -> Unit,
    onPerformanceClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onLogcatClicked) {
            Text(text = "Detect other apps logcat")
        }
        VerticalSpacer8Dp()
        Button(onClick = onMemoryClicked) {
            Text(text = "Detect memory leaks at your app")
        }
        VerticalSpacer8Dp()
        Button(onClick = onPerformanceClicked) {
            Text(text = "Check performance at your app")
        }
    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(paddingValues = PaddingValues(), {}, {}){}
}