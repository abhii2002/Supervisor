package com.blissvine.supervisor.repository


import com.blissvine.supervisor.fetchedPhotoModel.PhotoModel
import com.blissvine.supervisor.network.ApiService
import retrofit2.Response

class Repository(private val apiService: ApiService) {


    suspend fun fetchGuidlines(sid: String) : Response<List<PhotoModel>> = apiService.fetchPhotoDetails(sid)
}