package com.diegochancafe.curiosity.data.network

import com.diegochancafe.curiosity.data.model.response.NasaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

// /mars-photos/api/v1/rovers/curiosity/photos?sol=10&page=1&api_key=
interface IRetrofitApi {
    @GET
    suspend fun getPhotos(
        @Url url: String
    ): Response<NasaResponse>
}