package com.kilica.marvelmobven.presentation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
    object SeeAllScreen: Screen("see_all_screen")
}
