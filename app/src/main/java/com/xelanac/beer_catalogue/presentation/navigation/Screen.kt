package com.xelanac.beer_catalogue.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object BeerDetail : Screen("beer_detail")
    object MyBeer : Screen("my_beer_screen")
}