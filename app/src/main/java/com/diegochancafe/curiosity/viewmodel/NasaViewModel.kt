package com.diegochancafe.curiosity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegochancafe.curiosity.domain.model.PhotoDomain
import com.diegochancafe.curiosity.domain.usecase.GetNasaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NasaViewModel @Inject constructor(
    private val getNasaUseCase: GetNasaUseCase
): ViewModel() {
    val nasaModelDomain: MutableLiveData<List<PhotoDomain>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun getPhotos(url: String) {
        isLoading.postValue(true)
        viewModelScope.launch {
            try {
                val result = getNasaUseCase.invoke(url)
                nasaModelDomain.postValue(result)
                isLoading.postValue(false)
            } catch (e: Exception) {
                isLoading.postValue(false)
            }
        }
    }
}