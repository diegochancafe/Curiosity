package com.diegochancafe.curiosity.domain.model

import com.diegochancafe.curiosity.data.model.response.NasaModelResponse
import com.diegochancafe.curiosity.data.model.response.PhotoResponse

data class NasaModelDomain(
    val photos: List<PhotoDomain>
)

data class PhotoDomain(
    val id: Int,
    val sol: Int,
    val imageSrc: String
)

fun PhotoResponse.toDomain() = PhotoDomain(id, sol, imageSrc)
fun NasaModelResponse.toDomain() = NasaModelDomain(photos = photos.map { it.toDomain() })
