package com.diegochancafe.curiosity.domain.usecase

import com.diegochancafe.curiosity.data.repository.NasaRepository
import com.diegochancafe.curiosity.domain.model.NasaModelDomain
import com.diegochancafe.curiosity.domain.model.PhotoDomain
import javax.inject.Inject

class GetNasaUseCase @Inject constructor(private val repository: NasaRepository) {
    suspend operator fun invoke(url: String): List<PhotoDomain> {
        return repository.getPhotos(url)
    }
}