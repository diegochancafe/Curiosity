package com.diegochancafe.curiosity.data.repository

import com.diegochancafe.curiosity.data.network.service.NasaService
import com.diegochancafe.curiosity.domain.model.PhotoDomain
import com.diegochancafe.curiosity.domain.model.toDomain
import javax.inject.Inject

class NasaRepository @Inject constructor(
    private val api: NasaService
) {
    suspend fun getPhotos(url: String): List<PhotoDomain> {
        val result = api.getPhotos(url)
        return result?.photos?.map { it.toDomain() } ?: emptyList()
    }
}
