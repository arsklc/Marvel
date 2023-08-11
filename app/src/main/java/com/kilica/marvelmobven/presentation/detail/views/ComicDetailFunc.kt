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
import com.kilica.marvelmobven.domain.model.Comic
import com.kilica.marvelmobven.presentation.common.StatisticsBar
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicCharactersRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicCreatorsRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicEventRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicSeriesRow
import com.kilica.marvelmobven.presentation.detail.views.comicdetailviews.ComicStoriesRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroComicsRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroEventRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroSeriesRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroStoriesRow
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun ComicDetailFunc(comic: Comic) {
    val scrollState = rememberLazyListState()
    val count = comic.series.name.split(",").size
    val isAgeIconClicked = remember { mutableStateOf(true) }
    val isWeightIconClicked = remember { mutableStateOf(false) }
    val isHeightIconClicked = remember { mutableStateOf(false) }
    val isUniverseIconClicked = remember { mutableStateOf(false) }
    val isComicIconClicked = remember { mutableStateOf(false) }
    LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
        item {
            CoilImage(
                modifier = Modifier.fillMaxWidth(),
                imageModel = { comic.comicimageUrl },
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
                    text = comic.title,
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
                        modifier = Modifier.size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = true
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = comic.events.available.toString(),
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.height),
                        contentDescription = "image",
                        modifier = Modifier.size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = true
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = comic.stories.available.toString(),
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.weight),
                        contentDescription = "image",
                        modifier = Modifier.size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = true
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = comic.characters.available.toString(),
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.universe),
                        contentDescription = "image",
                        modifier = Modifier.size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = true
                                isComicIconClicked.value = false
                            }
                    )
                    Text(
                        text = comic.creators.available.toString(),
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.comic),
                        contentDescription = "image",
                        modifier = Modifier.size(40.dp)
                            .clickable {
                                isAgeIconClicked.value = false
                                isWeightIconClicked.value = false
                                isHeightIconClicked.value = false
                                isUniverseIconClicked.value = false
                                isComicIconClicked.value = true
                            }
                    )
                    Text(
                        text = count.toString(),
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }
            }
        }
        item {
            Text(
                text = comic.description,
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
                    text = "Events =",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                StatisticsBar(statisticValue = comic.events.available)
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
                StatisticsBar(statisticValue = count)
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
                StatisticsBar(statisticValue = comic.stories.available)
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
                StatisticsBar(statisticValue = comic.creators.available)
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
                    text = "Heroes =",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                StatisticsBar(statisticValue = comic.characters.available)
            }
        }
        item {
            if (isAgeIconClicked.value) {
                Text(
                    text = "EVENTS",
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
                    text = "HEROES",
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
                    text = "STORIES",
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
            else if (isComicIconClicked.value) {
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
            }
        }
        item {
            if (isAgeIconClicked.value) {
                ComicEventRow(comic = comic)
            } else if (isWeightIconClicked.value) {
                ComicCharactersRow(comic = comic)
            } else if (isHeightIconClicked.value) {
                ComicStoriesRow(comic = comic)
            } else if (isComicIconClicked.value) {
                ComicSeriesRow(comic = comic)
            } else if (isUniverseIconClicked.value) {
                ComicCreatorsRow(comic = comic)
            }
        }
    }
}