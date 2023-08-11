package com.kilica.marvelmobven.presentation.seeallpage

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kilica.marvelmobven.presentation.Screen
import com.kilica.marvelmobven.presentation.homepage.ComicViewModel
import com.kilica.marvelmobven.presentation.homepage.CreatorViewModel
import com.kilica.marvelmobven.presentation.homepage.EventViewModel
import com.kilica.marvelmobven.presentation.homepage.HeroesViewModel
import com.kilica.marvelmobven.presentation.homepage.SeriesViewModel
import com.kilica.marvelmobven.presentation.homepage.StoryViewModel
import com.kilica.marvelmobven.presentation.homepage.views.ComicListRow
import com.kilica.marvelmobven.presentation.homepage.views.CreatorListRow
import com.kilica.marvelmobven.presentation.homepage.views.EventListRow
import com.kilica.marvelmobven.presentation.homepage.views.HeroListRow
import com.kilica.marvelmobven.presentation.homepage.views.SeriesListRow
import com.kilica.marvelmobven.presentation.homepage.views.StoryListRow
import com.kilica.marvelmobven.util.ItemType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeeAllScreen(
    navController: NavController,
    viewModel: HeroesViewModel = hiltViewModel(),
    comicviewModel: ComicViewModel = hiltViewModel(),
    creatorviewModel: CreatorViewModel = hiltViewModel(),
    eventviewModel: EventViewModel = hiltViewModel(),
    seriesviewModel: SeriesViewModel = hiltViewModel(),
    storiesviewModel: StoryViewModel = hiltViewModel(),
    currentItemType: ItemType,
) {
    val state = viewModel.state.value
    val comicState = comicviewModel.state.value
    val creatorState = creatorviewModel.state.value
    val eventsState = eventviewModel.state.value
    val seriesState = seriesviewModel.state.value
    val storiesState = storiesviewModel.state.value
    val scrollState = rememberLazyListState()
    val itemType = remember { mutableStateOf(ItemType.HERO) }
    val searchQuery = remember { mutableStateOf("") }

    Log.d("ItemType", "Item type updated: ${itemType.value}")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = scrollState
    ) {
        item {
            TextField(
                value = searchQuery.value,
                onValueChange = { newValue ->
                    searchQuery.value = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 16.dp),
                label = { Text("Search") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black
                )
            )
        }

        when (currentItemType) {
            ItemType.HERO -> {
                item {
                    Text(
                        text = "HEROES",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                itemsIndexed(state.heroes.filter { hero ->
                    hero.name.contains(searchQuery.value, ignoreCase = true)
                }) { index, hero ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            HeroListRow(hero = hero, onItemClick = {
                                itemType.value = ItemType.HERO
                                navController.navigate(Screen.DetailScreen.route + "/${hero.id}/${ItemType.HERO.name}")
                            })

                            val secondIndex = index + 1
                            if (secondIndex < state.heroes.size) {
                                val secondHero = state.heroes[secondIndex]
                                HeroListRow(hero = secondHero, onItemClick = {
                                    itemType.value = ItemType.HERO
                                    navController.navigate(Screen.DetailScreen.route + "/${hero.id}/${ItemType.HERO.name}")
                                })
                            }
                        }
                    }
                }
            }

            ItemType.COMIC -> {
                val filteredComics = comicState.comics.filter { comic ->
                    comic.title.contains(searchQuery.value, ignoreCase = true)
                }

                item {
                    Text(
                        text = "COMICS",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                itemsIndexed(filteredComics) { index, comic ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            ComicListRow(comic = comic, onItemClick = {
                                navController.navigate(Screen.DetailScreen.route + "/${comic.id}/${ItemType.COMIC.name}")
                                itemType.value = ItemType.COMIC
                            })

                            val secondIndex = index + 1
                            if (secondIndex < filteredComics.size) {
                                val secondComic = filteredComics[secondIndex]
                                ComicListRow(comic = secondComic, onItemClick = {
                                    navController.navigate(Screen.DetailScreen.route + "/${comic.id}/${ItemType.COMIC.name}")
                                    itemType.value = ItemType.COMIC
                                })
                            }
                        }
                    }
                }
            }
            ItemType.CREATOR -> {
                val filteredCreators = creatorState.creators.filter { creator ->
                    creator.fullName.contains(searchQuery.value, ignoreCase = true)
                }

                item {
                    Text(
                        text = "CREATORS",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                itemsIndexed(filteredCreators) { index, creator ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CreatorListRow(creator = creator, onItemClick = {
                                navController.navigate(Screen.DetailScreen.route + "/${creator.id}/${ItemType.CREATOR.name}")
                                itemType.value = ItemType.CREATOR
                            })

                            val secondIndex = index + 1
                            if (secondIndex < filteredCreators.size) {
                                val secondCreator = filteredCreators[secondIndex]
                                CreatorListRow(creator = secondCreator, onItemClick = {
                                    navController.navigate(Screen.DetailScreen.route + "/${secondCreator.id}/${ItemType.CREATOR.name}")
                                    itemType.value = ItemType.CREATOR
                                })
                            }
                        }
                    }
                }
            }

            ItemType.EVENT -> {
                val filteredEvents = eventsState.events.filter { event ->
                    event.title.contains(searchQuery.value, ignoreCase = true)
                }

                item {
                    Text(
                        text = "EVENTS",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                itemsIndexed(filteredEvents) { index, event ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            EventListRow(event = event, onItemClick = {
                                navController.navigate(Screen.DetailScreen.route + "/${event.id}/${ItemType.EVENT.name}")
                                itemType.value = ItemType.EVENT
                            })

                            val secondIndex = index + 1
                            if (secondIndex < filteredEvents.size) {
                                val secondEvent = filteredEvents[secondIndex]
                                EventListRow(event = secondEvent, onItemClick = {
                                    navController.navigate(Screen.DetailScreen.route + "/${secondEvent.id}/${ItemType.EVENT.name}")
                                    itemType.value = ItemType.EVENT
                                })
                            }
                        }
                    }
                }
            }

            ItemType.SERIES -> {
                val filteredSeries = seriesState.series.filter { series ->
                    series.title.contains(searchQuery.value, ignoreCase = true)
                }

                item {
                    Text(
                        text = "SERIES",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                itemsIndexed(filteredSeries) { index, series ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            SeriesListRow(series = series, onItemClick = {
                                navController.navigate(Screen.DetailScreen.route + "/${series.id}/${ItemType.SERIES.name}")
                                itemType.value = ItemType.SERIES
                            })

                            val secondIndex = index + 1
                            if (secondIndex < filteredSeries.size) {
                                val secondSeries = filteredSeries[secondIndex]
                                SeriesListRow(series = secondSeries, onItemClick = {
                                    navController.navigate(Screen.DetailScreen.route + "/${secondSeries.id}/${ItemType.SERIES.name}")
                                    itemType.value = ItemType.SERIES
                                })
                            }
                        }
                    }
                }
            }

            ItemType.STORY -> {
                val filteredStories = storiesState.stories.filter { story ->
                    story.title.contains(searchQuery.value, ignoreCase = true)
                }

                item {
                    Text(
                        text = "STORIES",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                itemsIndexed(filteredStories) { index, story ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            StoryListRow(story = story, onItemClick = {
                                navController.navigate(Screen.DetailScreen.route + "/${story.id}/${ItemType.STORY.name}")
                                itemType.value = ItemType.STORY
                            })

                            val secondIndex = index + 1
                            if (secondIndex < filteredStories.size) {
                                val secondStory = filteredStories[secondIndex]
                                StoryListRow(story = secondStory, onItemClick = {
                                    navController.navigate(Screen.DetailScreen.route + "/${secondStory.id}/${ItemType.STORY.name}")
                                    itemType.value = ItemType.STORY
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}