package com.diegochancafe.curiosity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegochancafe.curiosity.domain.model.PhotoDomain
import com.diegochancafe.curiosity.domain.usecase.GetNasaUseCase
import com.diegochancafe.curiosity.util.Config
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NasaViewModel @Inject constructor(
    private val getNasaUseCase: GetNasaUseCase
) : ViewModel() {
    // --
    private val _photos = MutableStateFlow<List<PhotoDomain>>(emptyList())
    private val _isLoading = MutableStateFlow(false)
    private val _errorMessage = MutableStateFlow<String?>(null)

    // --
    val photos: StateFlow<List<PhotoDomain>> = _photos.asStateFlow()
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    // --
    private var currentPage = 1
    private val apiKey = "dUwg5MAJhyJZEQKO6BxXDUU4lXN4nFa6yac6lVd2"

    // --
    fun getPhotos() {
        // --
        if (currentPage > 1) {
            _isLoading.value = false
        } else {
            _isLoading.value = true
        }

        // --
        viewModelScope.launch {
            try {
                // --
                val newPhotos =
                    getNasaUseCase.invoke("${Config.WEBSERVICE}photos?sol=3&page=$currentPage&api_key=$apiKey")
                _photos.value += newPhotos
                // --
                currentPage++
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage ?: "Error desconocido"
            } finally {
                _isLoading.value = false
            }
        }
    }
}