package com.xelanac.beer_catalogue.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.xelanac.beer_catalogue.R
import com.xelanac.beer_catalogue.common.Shimmer
import com.xelanac.beer_catalogue.domain.model.Beer
import com.xelanac.beer_catalogue.presentation.screen.my_beer.SetText

@Composable
fun BeerDetailComponent(
    beer: Beer?,
    showShimmer: MutableState<Boolean>
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, start = 50.dp, end = 50.dp)
                .background(Shimmer.shimmerBrush(showShimmer = showShimmer.value)),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(beer?.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = beer?.name,
                modifier = Modifier.size(150.dp),
                error = painterResource(R.drawable.ic_beer)
            )
        }

        showShimmer.value = beer == null

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "${stringResource(id = R.string.beer)}: ", fontSize = 22.sp)
            SetText(beer?.name ?: "", 22.sp, showShimmer.value)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = stringResource(id = R.string.description), fontSize = 18.sp)
            SetText(beer?.description ?: "", 18.sp, showShimmer.value)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "${stringResource(id = R.string.abv)}: ", fontSize = 18.sp)
            SetText("${beer?.abv ?: ""} %", 18.sp, showShimmer.value)
        }
    }
}