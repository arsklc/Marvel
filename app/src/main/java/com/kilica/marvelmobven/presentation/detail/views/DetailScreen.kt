package com.kilica.marvelmobven.presentation.detail.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kilica.marvelmobven.presentation.detail.ComicDetailViewModel
import com.kilica.marvelmobven.presentation.detail.CreatorDetailViewModel
import com.kilica.marvelmobven.presentation.detail.EventDetailViewModel
import com.kilica.marvelmobven.presentation.detail.HeroDetailViewModel
import com.kilica.marvelmobven.presentation.detail.SeriesDetailViewModel
import com.kilica.marvelmobven.presentation.detail.StoryDetailViewModel
import com.kilica.marvelmobven.util.ItemType

@Composable
fun DetailScreen(
    navController: NavController,
    heroDetailViewModel: HeroDetailViewModel = hiltViewModel(),
    comicDetailViewModel: ComicDetailViewModel = hiltViewModel(),
    creatorDetailViewModel: CreatorDetailViewModel = hiltViewModel(),
    eventDetailViewModel: EventDetailViewModel = hiltViewModel(),
    seriesDetailViewModel: SeriesDetailViewModel = hiltViewModel(),
    storyDetailViewModel: StoryDetailViewModel = hiltViewModel(),
    currentItemType: ItemType,
) {
    val state = heroDetailViewModel.state.value
    val comicstate = comicDetailViewModel.state.value
    val creatorstate = creatorDetailViewModel.state.value
    val eventstate = eventDetailViewModel.state.value
    val seriesstate = seriesDetailViewModel.state.value
    val storystate = storyDetailViewModel.state.value


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), contentAlignment = Alignment.Center
    ) {
        when (currentItemType) {
            ItemType.HERO -> {
                state.hero?.let { hero ->
                    HeroDetailFunc(hero = hero)
                }
            }
            ItemType.COMIC -> {
                comicstate.comic?.let { comic ->
                    ComicDetailFunc(comic = comic)
                    Log.d("KILIC", comic.comicimageUrl)
                    Log.d("ItemType", "Current ItemType: $currentItemType")
                }
            }
            ItemType.CREATOR -> {
                creatorstate.creator?.let { creator ->
                    CreatorDetailFunc(creator = creator)
                }
            }
            ItemType.EVENT -> {
                eventstate.event?.let { event ->
                    EventDetailFunc(event = event)
                }
            }
            ItemType.SERIES -> {
                seriesstate.series?.let { series ->
                    SeriesDetailFunc(series = series)
                }
            }
            ItemType.STORY -> {
                storystate.story?.let { story ->
                    StoryDetailFunc(story = story)
                }
            }
        }
    }
}