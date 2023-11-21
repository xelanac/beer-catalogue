package com.xelanac.beer_catalogue.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Method(
    @SerializedName("fermentation")
    val fermentation: Fermentation? = Fermentation(),
    @SerializedName("mash_temp")
    val mashTemp: List<MashTemp>? = listOf(),
    @SerializedName("twist")
    val twist: Any? = Any()
)