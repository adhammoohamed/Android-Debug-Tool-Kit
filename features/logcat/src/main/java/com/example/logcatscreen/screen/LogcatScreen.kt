package com.example.logcatscreen.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    viewModel: LogcatViewModel,
    state: List<AppInfo>,
    paddingValues: PaddingValues
) {
    val searchState by viewModel.searchQuery.collectAsState()

    LogcatScreenContent(
        paddingValues = paddingValues,
        appsState = state,
        searchState = searchState,
        onSearch = viewModel::updateSearchQuery
    )
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
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(vertical = 8.dp)
        .clickable {

        }) {
        Row(modifier = Modifier.fillMaxSize()) {
            DrawableImage(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterVertically),
                appInfo.icon
            )
            HorizontalSpacer8Dp()
            Column (modifier = Modifier.align(Alignment.CenterVertically)){
                Text(text = appInfo.name, fontSize = 22.sp)
                VerticalSpacer8Dp()
                Text(text = appInfo.packageName, fontSize = 16.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LogcatScreenPreview() {
//    LogcatScreenContent(emptyList(), "") {}
}