package com.xelanac.beer_catalogue.presentation.screen.beer_detail

import com.xelanac.beer_catalogue.domain.model.Beer

data class BeerDetailState(
    val isLoading: Boolean = false,
    val beer: Beer? = null,
    val error: String = ""
)