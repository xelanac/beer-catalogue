package com.xelanac.beer_catalogue.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Malt(
    @SerializedName("amount")
    val amount: Amount? = Amount(),
    @SerializedName("name")
    val name: String? = ""
)