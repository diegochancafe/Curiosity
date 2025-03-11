package com.diegochancafe.curiosity.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.diegochancafe.curiosity.view.component.LoaderComponent
import com.diegochancafe.curiosity.view.component.PhotoItem
import com.diegochancafe.curiosity.viewmodel.NasaViewModel

@Composable
fun PhotoListScreen(viewModel: NasaViewModel = hiltViewModel()) {
    // --
    val photos by viewModel.photos.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    // --
    LaunchedEffect(Unit) {
        viewModel.photos
    }

    // --
    Box(modifier = Modifier.fillMaxSize()) {
        // --
        if (isLoading) {
            LoaderComponent()
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(photos) { photo ->
                    PhotoItem(photo)
                }

                item {
                    // --
                    LaunchedEffect(Unit) {
                        viewModel.getPhotos()
                    }
                    // --
                    LoaderComponent()
                }
            }
        }
    }
}