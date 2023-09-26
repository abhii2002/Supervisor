package com.blissvine.supervisor.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blissvine.supervisor.fetchedPhotoModel.PhotoModel
import com.blissvine.supervisor.network.ApiClient
import com.blissvine.supervisor.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class SharedViewModel(private val repository: Repository = Repository(ApiClient.apiService)) : ViewModel(){

    var photosDetailsLiveData : MutableLiveData<Response<List<PhotoModel>>> = MutableLiveData()

    init {
        fetchPhotoDetails()
    }



    fun fetchPhotoDetails(){
        viewModelScope.launch {
            try {
                val response = repository.fetchGuidlines("6510201a0b7e17bee30cbc0b")
                photosDetailsLiveData.value = response

            }catch (e: Exception){
                Log.d("userException", e.message.toString())
            }
        }
    }



}