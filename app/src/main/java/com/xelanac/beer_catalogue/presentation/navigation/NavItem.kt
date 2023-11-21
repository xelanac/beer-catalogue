package com.xelanac.beer_catalogue.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalDrink
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val route: String
)

val navItems = listOf(
    NavItem(
        title = "Home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        route = Screen.Home.route
    ),
    NavItem(
        title = "MyBeer",
        unselectedIcon = Icons.Outlined.LocalDrink,
        selectedIcon = Icons.Filled.LocalDrink,
        route = Screen.MyBeer.route
    )
)