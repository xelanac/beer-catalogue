package com.xelanac.beer_catalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.xelanac.beer_catalogue.presentation.navigation.AppNavigation
import com.xelanac.beer_catalogue.ui.theme.Beer_catalogueTheme
import com.xelanac.beer_catalogue.ui.theme.YellowBeer
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Beer_catalogueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = YellowBeer
                ) {
                    AppNavigation()
                }
            }
        }
    }
}