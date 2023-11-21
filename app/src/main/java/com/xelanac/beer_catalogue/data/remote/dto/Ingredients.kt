package com.xelanac.beer_catalogue.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("hops")
    val hops: List<Hop>? = listOf(),
    @SerializedName("malt")
    val malt: List<Malt>? = listOf(),
    @SerializedName("yeast")
    val yeast: String? = ""
)