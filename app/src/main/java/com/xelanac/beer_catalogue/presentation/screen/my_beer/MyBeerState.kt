package com.xelanac.beer_catalogue.presentation.screen.my_beer

import com.xelanac.beer_catalogue.domain.model.Beer

data class MyBeerState(
    val isLoading: Boolean = false,
    val beer: Beer? = null,
    val error: String = ""
)
