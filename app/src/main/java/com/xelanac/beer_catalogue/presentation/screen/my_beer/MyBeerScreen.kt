package com.xelanac.beer_catalogue.presentation.screen.my_beer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xelanac.beer_catalogue.R
import com.xelanac.beer_catalogue.common.Shimmer
import com.xelanac.beer_catalogue.presentation.screen.components.BeerDetailComponent
import com.xelanac.beer_catalogue.ui.theme.GreenBeer
import com.xelanac.beer_catalogue.ui.theme.YellowBeer

@Composable
fun MyBeerScreen(
    viewModel: MyBeerViewModel = hiltViewModel()
) {
    RandomBeerConstructor(viewModel)
}

@Composable
fun RandomBeerConstructor(viewModel: MyBeerViewModel) {
    val beerGenerated = remember { mutableStateOf(false) }
    val showShimmer = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GreenBeer.copy(0.05f)),
    ) {
        Text(
            text = buildAnnotatedString {
                append("${stringResource(id = R.string.get_random_label)} ")
                withStyle(style = SpanStyle(
                    color = GreenBeer,
                    fontSize = 35.sp
                )) {
                    append(stringResource(id = R.string.beer))
                }
                append(" !")
            },
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp, top = 50.dp),
            textAlign = TextAlign.Center
        )
        if (beerGenerated.value) {
            val state = viewModel.state.value


            state.beer.let { beer ->
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                        shape = RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = YellowBeer
                        )
                    ) {
                        BeerDetailComponent(beer = beer, showShimmer = showShimmer)
                    }
                }

            if(state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            BtnConstructor(beerGenerated, viewModel)
        }
    }
}

@Composable
fun SetText(text: String?, textSize: TextUnit, showShimmer: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Shimmer.shimmerBrush(showShimmer = showShimmer))
            .padding(
                bottom = 20.dp,
            ),
    ) {
        Text(
            text = text!!,
            fontSize = textSize,
            color = GreenBeer,
            maxLines = 11
        )
    }
}

@Composable
fun BtnConstructor(beerGenerated: MutableState<Boolean>, viewModel: MyBeerViewModel) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                beerGenerated.value = true
                viewModel.getMyBeer()
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenBeer,
                contentColor = Color.White
            ),
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = stringResource(id = R.string.generate))
        }
    }
}