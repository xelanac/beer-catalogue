package com.xelanac.beer_catalogue.presentation.screen.beer_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xelanac.beer_catalogue.presentation.screen.components.BeerDetailComponent
import com.xelanac.beer_catalogue.R
import com.xelanac.beer_catalogue.presentation.navigation.Screen
import com.xelanac.beer_catalogue.ui.theme.GreenBeer

@Composable
fun BeerDetailScreen(
    navHostController: NavHostController,
    viewModel: BeerDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val showShimmer = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = GreenBeer.copy(0.05f))
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_arrow_back),
            contentDescription = "arrow_back",
            modifier = Modifier
                .size(50.dp)
                .padding(start = 20.dp, top = 20.dp)
                .clickable {
                    navHostController.popBackStack()
                    /*
                    navHostController.navigate(Screen.Home.route){
                        popUpTo(navHostController.graph.id) {
                            inclusive = true
                        }
                    }
                     */
                }
        )

        state.beer.let { beer ->
            BeerDetailComponent(beer = beer, showShimmer = showShimmer)
        }
    }
}