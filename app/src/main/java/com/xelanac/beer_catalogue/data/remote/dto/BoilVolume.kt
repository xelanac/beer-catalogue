package com.xelanac.beer_catalogue.data.remote.dto


import com.google.gson.annotations.SerializedName

data class BoilVolume(
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Int? = 0
)