package com.xelanac.beer_catalogue.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Amount(
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Double? = 0.0
)