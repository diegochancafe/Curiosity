package com.diegochancafe.curiosity.data.network

import com.diegochancafe.curiosity.data.model.response.NasaModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

// --
interface IRetrofitApi {
    @GET
    suspend fun getPhotos(
        @Url url: String
    ): Response<NasaModelResponse>
}