package com.diegochancafe.curiosity.data.network.service

import com.diegochancafe.curiosity.data.model.response.NasaResponse
import com.diegochancafe.curiosity.data.network.IRetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NasaService @Inject constructor(private val api: IRetrofitApi) {
    suspend fun getPhotos(url: String): NasaResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPhotos(url)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}