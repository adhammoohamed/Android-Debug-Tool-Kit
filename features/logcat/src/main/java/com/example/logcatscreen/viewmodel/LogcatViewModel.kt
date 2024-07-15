package com.example.logcatscreen.viewmodel

import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogcatViewModel @Inject constructor() : ViewModel() {

    var searchQuery = MutableStateFlow("")
        private set

    private var _appInfo = MutableStateFlow<List<AppInfo>>(value = emptyList())
    private var _isLoading = MutableStateFlow(false)

    val appInfo = searchQuery.combine(_appInfo) { query, apps ->
        apps.filter { it.doesSearchQueryMatch(query) }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _appInfo.value)

    val isLoading =
        _isLoading.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _isLoading.value)

    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }

    fun getInstalledApps(packageManager: PackageManager) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            val apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA).map {
                val appName = it.loadLabel(packageManager).toString()
                val appIcon = it.loadIcon(packageManager)

                AppInfo(
                    name = appName,
                    packageName = it.packageName,
                    icon = appIcon
                )
            }
            _appInfo.value = apps
            _isLoading.value = false
        }
    }
}

data class AppInfo(var name: String, var packageName: String, var icon: Drawable) {
    fun doesSearchQueryMatch(query: String): Boolean {
        return name.contains(query, ignoreCase = true) || packageName.contains(
            query,
            ignoreCase = true
        )
    }
}
