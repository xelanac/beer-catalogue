package com.xelanac.beer_catalogue.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.xelanac.beer_catalogue.R
import com.xelanac.beer_catalogue.domain.model.Beer
import com.xelanac.beer_catalogue.presentation.navigation.Screen
import com.xelanac.beer_catalogue.ui.theme.GreenBeer
import com.xelanac.beer_catalogue.ui.theme.YellowBeer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeerItem(
    navController: NavHostController,
    beer: Beer
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = YellowBeer.copy(0.3f)
        ),
        onClick = {
            navController.navigate(Screen.BeerDetail.route + "/${beer.id}")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = Modifier
                    .height(130.dp)
                    .weight(0.25f)
                    .padding(start = 20.dp, end = 20.dp),
                error = painterResource(R.drawable.ic_beer)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .weight(0.5f)
            ) {
                Text(
                    text = beer.name ?: "Beer name",
                    color = GreenBeer,
                    fontSize = 20.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "ABV: ${beer.abv} %", fontSize = 14.sp)
                    Spacer(Modifier.size(15.dp))
                    Text(text = "FB: ${beer.firstBrewed}", fontSize = 14.sp)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward),
                contentDescription = "arrow forward",
                modifier = Modifier.weight(0.25f)
            )
        }
    }
}