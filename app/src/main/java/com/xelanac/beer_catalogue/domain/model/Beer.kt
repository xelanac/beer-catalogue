package com.xelanac.beer_catalogue.domain.model

data class Beer(
    val id: Int?,
    val abv: Double?,
    val description: String?,
    val imageUrl: String?,
    val name: String?,
    val firstBrewed: String?
)
