package com.xelanac.beer_catalogue.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.paging.compose.LazyPagingItems
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.items
import com.xelanac.beer_catalogue.domain.model.Beer
import com.xelanac.beer_catalogue.ui.theme.GreenBeer

@Composable
fun HomeScreen(
    navController: NavHostController,
    beers: LazyPagingItems<Beer>
) {
    Box(
        modifier = Modifier
            .background(color = GreenBeer.copy(0.05f))
            .fillMaxSize()
    ) {
        if(beers.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(beers) { beer ->
                    if(beer != null) {
                        BeerItem(
                            navController = navController,
                            beer = beer
                        )
                    }
                }
                item {
                    if(beers.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator(
                            color = GreenBeer
                        )
                    }
                }
            }
        }
    }
}