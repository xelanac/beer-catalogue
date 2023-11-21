package com.xelanac.beer_catalogue.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Hop(
    @SerializedName("add")
    val add: String? = "",
    @SerializedName("amount")
    val amount: Amount? = Amount(),
    @SerializedName("attribute")
    val attribute: String? = "",
    @SerializedName("name")
    val name: String? = ""
)