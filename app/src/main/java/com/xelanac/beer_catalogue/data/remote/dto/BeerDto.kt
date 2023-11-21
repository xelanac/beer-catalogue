package com.xelanac.beer_catalogue.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.xelanac.beer_catalogue.data.local.BeerEntity
import com.xelanac.beer_catalogue.domain.model.Beer

data class BeerDto(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("abv")
    val abv: Double? = 0.0,
    /*
    @SerializedName("attenuation_level")
    val attenuationLevel: Double? = 0.0,
    @SerializedName("boil_volume")
    val boilVolume: BoilVolume? = BoilVolume(),
    @SerializedName("brewers_tips")
    val brewersTips: String? = "",
    @SerializedName("contributed_by")
    val contributedBy: String? = "",
    */
    @SerializedName("description")
    val description: String? = "",

    //@SerializedName("ebc")
    //val ebc: Int? = 0,
    @SerializedName("first_brewed")
    val firstBrewed: String? = "",
    /*
    @SerializedName("food_pairing")
    val foodPairing: List<String>? = listOf(),
    @SerializedName("ibu")
    val ibu: Int? = 0,
     */
    @SerializedName("image_url")
    val imageUrl: String? = "",
    /*
    @SerializedName("ingredients")
    val ingredients: Ingredients? = Ingredients(),
    @SerializedName("method")
    val method: Method? = Method(),
    @SerializedName("name")
    */
    val name: String? = "",
    /*
    @SerializedName("ph")
    val ph: Double? = 0.0,
    @SerializedName("srm")
    val srm: Int? = 0,
    @SerializedName("tagline")
    val tagline: String? = "",
    @SerializedName("target_fg")
    val targetFg: Int? = 0,
    @SerializedName("target_og")
    val targetOg: Int? = 0,
    @SerializedName("volume")
    val volume: Volume? = Volume()
     */
)

fun BeerDto.toBeer() = Beer(
    id = id,
    abv = abv,
    name = name,
    description = description,
    firstBrewed = firstBrewed,
    imageUrl = imageUrl
)

fun BeerDto.toBeerEntity() = BeerEntity(
    id = id,
    name = name,
    description = description,
    firstBrewed = firstBrewed,
    imageUrl = imageUrl,
    abv = abv
)

fun BeerEntity.toBeer() = Beer(
    id = id,
    name = name,
    description = description,
    firstBrewed = firstBrewed,
    imageUrl = imageUrl,
    abv = abv
)
