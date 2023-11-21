package com.xelanac.beer_catalogue.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import com.xelanac.beer_catalogue.presentation.screen.home.HomeScreen
import com.xelanac.beer_catalogue.presentation.screen.my_beer.MyBeerScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.xelanac.beer_catalogue.presentation.screen.beer_detail.BeerDetailScreen
import com.xelanac.beer_catalogue.presentation.screen.home.BeerViewModel

@Composable
fun NavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = androidx.compose.ui.Modifier.padding(paddingValues)
    ) {
        composable(route = Screen.Home.route) {
            val viewModel = hiltViewModel<BeerViewModel>()
            val beers = viewModel.beerPagingFlow.collectAsLazyPagingItems()

            HomeScreen(
                navController = navController,
                beers = beers
            )
        }

        composable(
            route = Screen.BeerDetail.route.plus("/{beerId}"),
            arguments = listOf(
                navArgument("beerId") {
                    type = NavType.IntType
                }
            )
        ) {
            BeerDetailScreen(
                navHostController = navController
            )
        }

        composable(route = Screen.MyBeer.route) {
            MyBeerScreen()
        }
    }
}