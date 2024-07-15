package com.example.logcatscreen.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.ui.DrawableImage
import com.example.core.ui.HorizontalSpacer8Dp
import com.example.core.ui.VerticalSpacer8Dp
import com.example.logcatscreen.viewmodel.AppInfo
import com.example.logcatscreen.viewmodel.LogcatViewModel

@Composable
fun LogcatScreen(
    navController: NavController,
    viewModel: LogcatViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    state: List<AppInfo>,
    isLoading: Boolean
) {

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LogcatScreenContent(
            paddingValues = paddingValues,
            appsState = state,
            searchState = viewModel.searchQuery.collectAsState().value,
            onSearch = viewModel::updateSearchQuery
        )
    }
}

@Composable
fun LogcatScreenContent(
    paddingValues: PaddingValues,
    appsState: List<AppInfo>,
    searchState: String,
    onSearch: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchState,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Search") },
            onValueChange = onSearch
        )
        LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
            items(appsState) { appInfo ->
                AppCard(appInfo = appInfo)
            }
        }
    }
}

@Composable
fun AppCard(appInfo: AppInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 8.dp)
            .clickable {
            }
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            DrawableImage(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterVertically),
                appInfo.icon
            )
            HorizontalSpacer8Dp()
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(text = appInfo.name)
                VerticalSpacer8Dp()
                Text(text = appInfo.packageName)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogcatScreenPreview() {
    LogcatScreenContent(
        paddingValues = PaddingValues(),
        appsState = emptyList(),
        searchState = "",
        onSearch = {})
}
