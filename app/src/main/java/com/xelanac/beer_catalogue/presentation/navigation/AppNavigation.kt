package com.xelanac.beer_catalogue.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xelanac.beer_catalogue.ui.theme.GreenBeer
import com.xelanac.beer_catalogue.ui.theme.YellowBeer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = GreenBeer.copy(alpha = 0.2f)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                navItems.forEach { navItem: NavItem ->
                    val isDestination = currentDestination?.hierarchy?.any { it.route == navItem.route } == true

                    NavigationBarItem(
                        selected = isDestination,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = GreenBeer,
                            selectedTextColor = GreenBeer,
                            unselectedIconColor = Color.Black,
                            unselectedTextColor = Color.Black,
                            indicatorColor = YellowBeer
                        ),
                        onClick = {
                                  navController.navigate(navItem.route){
                                      popUpTo(navController.graph.findStartDestination().id) {
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                                  },
                        icon = {
                            Icon(
                                imageVector = if (isDestination) navItem.selectedIcon else navItem.unselectedIcon,
                                contentDescription = navItem.title
                            )
                        },
                        label = {
                            Text(text = navItem.title)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}