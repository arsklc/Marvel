package com.kilica.marvelmobven.presentation.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kilica.marvelmobven.presentation.Screen
import com.kilica.marvelmobven.presentation.detail.ComicDetailViewModel
import com.kilica.marvelmobven.presentation.detail.CreatorDetailViewModel
import com.kilica.marvelmobven.presentation.detail.EventDetailViewModel
import com.kilica.marvelmobven.presentation.detail.HeroDetailViewModel
import com.kilica.marvelmobven.presentation.detail.SeriesDetailViewModel
import com.kilica.marvelmobven.presentation.detail.StoryDetailViewModel
import com.kilica.marvelmobven.presentation.detail.views.DetailScreen
import com.kilica.marvelmobven.presentation.homepage.views.HomeScreen
import com.kilica.marvelmobven.presentation.seeallpage.SeeAllScreen
import com.kilica.marvelmobven.util.Constants.ID
import com.kilica.marvelmobven.util.ItemType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelMobvenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val itemType = remember { mutableStateOf(ItemType.HERO) }
                    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController = navController, itemType = itemType)
                        }
                        composable(
                            route = "${Screen.DetailScreen.route}/{${ID}}/{itemType}",
                            arguments = listOf(navArgument("itemType") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getString(ID)
                            val itemTypeValue = backStackEntry.arguments?.getString("itemType")
                            val currentItemType = itemTypeValue?.let { ItemType.valueOf(it) } ?: ItemType.HERO
                            val viewModel = hiltViewModel<HeroDetailViewModel>()
                            val comicViewModel = hiltViewModel<ComicDetailViewModel>()
                            val creatorViewModel = hiltViewModel<CreatorDetailViewModel>()
                            val eventViewModel = hiltViewModel<EventDetailViewModel>()
                            val seriesViewModel = hiltViewModel<SeriesDetailViewModel>()
                            val storyViewModel = hiltViewModel<StoryDetailViewModel>()
                            DetailScreen(
                                heroDetailViewModel = viewModel,
                                comicDetailViewModel = comicViewModel,
                                creatorDetailViewModel = creatorViewModel,
                                eventDetailViewModel = eventViewModel,
                                seriesDetailViewModel = seriesViewModel,
                                storyDetailViewModel = storyViewModel,
                                currentItemType = currentItemType,
                                navController = navController
                            )
                        }
                        composable(
                            route = Screen.SeeAllScreen.route + "/{itemType}",
                            arguments = listOf(navArgument("itemType") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val itemTypeValue = backStackEntry.arguments?.getString("itemType")
                            val currentItemType = itemTypeValue?.let { ItemType.valueOf(it) } ?: ItemType.HERO
                            SeeAllScreen(navController = navController, currentItemType = currentItemType )
                        }
                    }
                }
            }
        }
    }
}