package com.blissvine.supervisor.fetchedPhotoModel

import com.squareup.moshi.Json

data class PhotoModel(
    @Json(name = "name")
      val name: String,
    @Json(name = "location")
    val location: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "photoClicked")
    val photoClicked: String

)