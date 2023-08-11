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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.navigation.NavController
import com.kilica.marvelmobven.R
import com.kilica.marvelmobven.domain.model.Hero
import com.kilica.marvelmobven.presentation.Screen
import com.kilica.marvelmobven.presentation.common.StatisticsBar
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroComicsRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroEventRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroSeriesRow
import com.kilica.marvelmobven.presentation.detail.views.herodetailviews.HeroStoriesRow
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun HeroDetailFunc(
    hero: Hero,
) {

    val scrollState = rememberLazyListState()
    val isAgeIconClicked = remember { mutableStateOf(true) }
    val isWeightIconClicked = remember { mutableStateOf(false) }
    val isHeightIconClicked = remember { mutableStateOf(false) }
    val isUniverseIconClicked = remember { mutableStateOf(false) }

        LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
            item {
                CoilImage(
                    modifier = Modifier.fillMaxWidth(),
                    imageModel = { hero.imageUrl },
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
                        text = hero.name,
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
                                }
                        )
                        Text(
                            text = hero.events.available.toString(),
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
                                }
                        )
                        Text(
                            text = hero.series.available.toString(),
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
                                }
                        )
                        Text(
                            text = hero.stories.available.toString(),
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
                                }
                        )
                        Text(
                            text = hero.comics.available.toString(),
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.White
                        )

                    }
                }
            }

            item {
                Text(
                    text = hero.description,
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
                    StatisticsBar(statisticValue = hero.events.available)
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
                    Spacer(modifier = Modifier.width(1.dp))
                    StatisticsBar(statisticValue = hero.series.available)
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
                    Spacer(modifier = Modifier.width(1.dp))
                    StatisticsBar(statisticValue = hero.stories.available)
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
                    Spacer(modifier = Modifier.width(1.dp))
                    StatisticsBar(statisticValue = hero.comics.available)
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
                        text = "SERIES",
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
                        text = "COMICS",
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
                    HeroEventRow(hero = hero)
                } else if (isWeightIconClicked.value) {
                    HeroSeriesRow(hero = hero)
                } else if (isHeightIconClicked.value) {
                    HeroStoriesRow(hero = hero)
                } else if (isUniverseIconClicked.value) {
                    HeroComicsRow(hero = hero)
                }
            }
        }
    }
