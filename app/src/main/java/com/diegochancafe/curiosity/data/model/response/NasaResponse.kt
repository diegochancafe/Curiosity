package com.diegochancafe.curiosity.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NasaResponse(
    val photos: List<PhotoResponse> = emptyList()
): Serializable

data class PhotoResponse(
    val id: Int,
    val sol: Int,
    @SerializedName("img_src")
    val imageSrc: String
): Serializable