package com.kilica.marvelmobven.presentation.detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kilica.marvelmobven.R
import com.kilica.marvelmobven.domain.model.Event
import com.kilica.marvelmobven.presentation.common.StatisticsBar
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicCharactersRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicCreatorsRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicEventRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicSeriesRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicStoriesRow
import com.kilica.marvelmobven.presentation.detail.views.eventdetailviews.EventCharactersRow
import com.kilica.marvelmobven.presentation.detail.views.eventdetailviews.EventComicsRow
import com.kilica.marvelmobven.presentation.detail.views.eventdetailviews.EventCreatorsRow
import com.kilica.marvelmobven.presentation.detail.views.eventdetailviews.EventSeriesRow
import com.kilica.marvelmobven.presentation.detail.views.eventdetailviews.EventStoryRow
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun EventDetailFunc(
    event: Event
){
    val scrollState = rememberLazyListState()
    val isAgeIconClicked = remember { mutableStateOf(true) }
    val isWeightIconClicked = remember { mutableStateOf(false) }
    val isHeightIconClicked = remember { mutableStateOf(false) }
    val isUniverseIconClicked = remember { mutableStateOf(false) }
    val isComicIconClicked = remember { mutableStateOf(false) }

    LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState){
        item{
            CoilImage(
                modifier = Modifier.fillMaxWidth(),
                imageModel = {event.eventimageUrl},
                imageOptions = ImageOptions(
                    contentScale = ContentScale.FillHeight
                ),
                component = rememberImageComponent {
                    +ShimmerPlugin(
                        baseColor = Color.Gray,
                        highlightColor = Color.White
                    )
                }
            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            ) {
                Text(
                    text = event.title,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 25.dp),
                    fontSize = 30.sp,
                    color = Color.White

                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.age),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = true
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = event.characters.available.toString(),
                        modifier = Modifier
                            .padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.weight),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = true
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = event.stories.available.toString(),
                        modifier = Modifier
                            .padding(8.dp),
                        color = Color.White
                    )

                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.height),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = true
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = event.series.available.toString(),
                        modifier = Modifier
                            .padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.universe),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = true
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = event.comics.available.toString(),
                        modifier = Modifier
                            .padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.comic),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = true
                            }
                    )
                    Text(
                        text = event.creators.available.toString(),
                        modifier = Modifier
                            .padding(8.dp),
                        color = Color.White
                    )
                }
            }
        }
        item {
            Text(
                text = event.description,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color.White
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Heroes =",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                StatisticsBar(statisticValue = event.characters.available)
            }
        }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Stories =",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    StatisticsBar(statisticValue = event.stories.available)
                }
            }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Series =",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                StatisticsBar(statisticValue = event.series.available)
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Comics =",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                StatisticsBar(statisticValue = event.comics.available)
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Creators =",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                StatisticsBar(statisticValue = event.creators.available)
            }
        }
        item {
            if (isAgeIconClicked.value) {
                Text(
                    text = "HEROES",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White

                )
            } else if (isWeightIconClicked.value) {
                Text(
                    text = "STORIES",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White

                )
            } else if (isHeightIconClicked.value) {
                Text(
                    text = "SERIES",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White

                )
            } else if (isUniverseIconClicked.value) {
                Text(
                    text = "COMIC",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White

                )
            }
            else if (isComicIconClicked.value) {
                Text(
                    text = "CREATORS",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White

                )
            }
        }
        item {
            if (isAgeIconClicked.value) {
                EventCharactersRow(event = event)
            } else if (isWeightIconClicked.value) {
                EventStoryRow(event = event)
            } else if (isHeightIconClicked.value) {
                EventSeriesRow(event = event)
            } else if (isComicIconClicked.value) {
                EventCreatorsRow(event = event)
            } else if (isUniverseIconClicked.value) {
                EventComicsRow(event = event)
            }
        }
    }
}