package com.kilica.marvelmobven.presentation.homepage.views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kilica.marvelmobven.R
import com.kilica.marvelmobven.presentation.Screen
import com.kilica.marvelmobven.presentation.common.LoadingAnimation
import com.kilica.marvelmobven.presentation.homepage.ComicViewModel
import com.kilica.marvelmobven.presentation.homepage.CreatorViewModel
import com.kilica.marvelmobven.presentation.homepage.EventViewModel
import com.kilica.marvelmobven.presentation.homepage.HeroesViewModel
import com.kilica.marvelmobven.presentation.homepage.SeriesViewModel
import com.kilica.marvelmobven.presentation.homepage.StoryViewModel
import com.kilica.marvelmobven.util.ItemType
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    state: MutableState<ItemType> = remember { mutableStateOf(ItemType.HERO) },
    viewModel: HeroesViewModel = hiltViewModel(),
    comicviewModel: ComicViewModel = hiltViewModel(),
    creatorviewModel: CreatorViewModel = hiltViewModel(),
    eventviewModel: EventViewModel = hiltViewModel(),
    seriesviewModel: SeriesViewModel = hiltViewModel(),
    storiesviewModel: StoryViewModel = hiltViewModel(),
    itemType: MutableState<ItemType>
) {
    val state = viewModel.state.value
    val comicState = comicviewModel.state.value
    val creatorState = creatorviewModel.state.value
    val eventsState = eventviewModel.state.value
    val seriesState = seriesviewModel.state.value
    val storiesState = storiesviewModel.state.value

    val isComicIconClicked = remember { mutableStateOf(false) }
    val isCreatorIconClicked = remember { mutableStateOf(false) }
    val isEventIconClicked = remember { mutableStateOf(false) }
    val isSeriesIconClicked = remember { mutableStateOf(false) }
    val isStoryIconClicked = remember { mutableStateOf(false) }

    val itemType = remember { mutableStateOf(ItemType.HERO) }

    if (state.error != null) {
        val dismissState = remember { mutableStateOf(false) }
        if (dismissState.value) return
        Dialog(onDismissRequest = { dismissState.value = true }) {
            Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
                Text(text = state.error, Modifier.align(Alignment.Center))
            }
        }
    } else if (state.shouldShowLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            LoadingAnimation(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(isComicIconClicked.value) {
            if (isComicIconClicked.value) {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(5)
                }

                isComicIconClicked.value = false
            }
        }

        LaunchedEffect(isCreatorIconClicked.value) {
            if (isCreatorIconClicked.value) {
                coroutineScope.launch {

                    scrollState.animateScrollToItem(7)
                }

                isCreatorIconClicked.value = false
            }
        }
        LaunchedEffect(isEventIconClicked.value) {
            if (isEventIconClicked.value) {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(9)
                }
                isEventIconClicked.value = false
            }
        }
        LaunchedEffect(isSeriesIconClicked.value) {
            if (isSeriesIconClicked.value) {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(11)
                }
                isSeriesIconClicked.value = false
            }
        }
        LaunchedEffect(isStoryIconClicked.value) {
            if (isStoryIconClicked.value) {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(13)
                }
                isStoryIconClicked.value = false
            }
        }

        LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.appbar),
                    contentDescription = "image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
            item {
                Text(
                    text = "Bem vindo ao Marvel",
                    fontSize = 14.sp,
                    color = Color(0xFFB7B7C8),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
            }

            item {
                Text(
                    text = "Escolha o seu personagem",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.comic_icon),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(65.dp)
                            .clickable {
                                isComicIconClicked.value = true
                            }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.creators_icon),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(65.dp)
                            .clickable{
                                isCreatorIconClicked.value = true
                            }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.events_icon),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(65.dp)
                            .clickable { isEventIconClicked.value = true }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.series_icon),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(65.dp)
                            .clickable { isSeriesIconClicked.value = true }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.stories_icon),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(65.dp)
                            .clickable { isStoryIconClicked.value = true }
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Heroes",
                        fontSize = 18.sp,
                        color = Color(0xFFf2264b),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "See All",
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                itemType.value = ItemType.HERO
                                navController.navigate("${Screen.SeeAllScreen.route}/${ItemType.HERO}")

                            }
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(state.heroes) { hero ->
                        HeroListRow(hero = hero, onItemClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${hero.id}/${ItemType.HERO}")
                        })
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Comics",
                        fontSize = 18.sp,
                        color = Color(0xFFf2264b),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding( top = 8.dp)
                    )
                    Text(
                        text = "See All",
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                            itemType.value = ItemType.COMIC
                            Log.d("SeeAll", "seeall type updated: ${itemType.value}")
                            navController.navigate(Screen.SeeAllScreen.route+"/${ItemType.COMIC}")
                            }
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(comicState.comics) { comic ->
                        ComicListRow(comic = comic, onItemClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${comic.id}/${ItemType.COMIC}")
                            itemType.value = ItemType.COMIC
                            Log.d("ItemType", "Item type updated: ${itemType.value}")
                        })
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Creators",
                        fontSize = 18.sp,
                        color = Color(0xFFf2264b),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "See All",
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                itemType.value = ItemType.CREATOR
                                navController.navigate(Screen.SeeAllScreen.route+"/${ItemType.CREATOR}")
                            }
                    )
                }
            }
            Log.d("HeroScreen", "creator number: ${creatorState.creators.size}")
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(creatorState.creators) { creator ->
                        CreatorListRow(creator = creator, onItemClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${creator.id}/${ItemType.CREATOR}")
                            itemType.value = ItemType.CREATOR
                            Log.d("ItemType", "Item type updated: ${itemType.value}")
                        })
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Events",
                        fontSize = 18.sp,
                        color = Color(0xFFf2264b),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "See All",
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                itemType.value = ItemType.EVENT
                                navController.navigate(Screen.SeeAllScreen.route+"/${ItemType.EVENT}")
                                Log.d("ItemType", "Item type updated: ${itemType.value}")
                            }
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(eventsState.events) { event ->
                        EventListRow(event = event, onItemClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${event.id}/${ItemType.EVENT}")
                            itemType.value = ItemType.EVENT
                            Log.d("ItemType", "Item type updated: ${itemType.value}")
                        })
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Series",
                        fontSize = 18.sp,
                        color = Color(0xFFf2264b),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "See All",
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                itemType.value = ItemType.SERIES
                                navController.navigate(Screen.SeeAllScreen.route+"/${ItemType.SERIES}")
                            }
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(seriesState.series) { series ->
                        SeriesListRow(series = series, onItemClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${series.id}/${ItemType.SERIES}")
                            itemType.value = ItemType.SERIES
                            Log.d("ItemType", "Item type updated: ${itemType.value}")
                        })
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Stories",
                        fontSize = 18.sp,
                        color = Color(0xFFf2264b),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "See All",
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                itemType.value = ItemType.STORY
                                navController.navigate(Screen.SeeAllScreen.route+"/${ItemType.STORY}")
                            }
                    )
                }
            }
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(storiesState.stories) { stories ->
                        StoryListRow(story = stories, onItemClick = {
                            navController.navigate(Screen.DetailScreen.route + "/${stories.id}/${ItemType.STORY}")
                            itemType.value = ItemType.STORY
                            Log.d("ItemType", "Item type updated: ${itemType.value}")
                        })
                    }
                }
            }
        }
    }
}