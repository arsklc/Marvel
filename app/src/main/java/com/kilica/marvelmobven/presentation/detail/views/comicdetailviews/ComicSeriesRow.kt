package com.kilica.marvelmobven.presentation.detail.views.comicdetailviews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kilica.marvelmobven.domain.model.Comic
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun ComicSeriesRow(comic: Comic) {
    val count = comic.series.name.split(",").size
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(count) { index ->
            Card(
                modifier = Modifier
                    .size(140.dp, 230.dp)
                    .padding(8.dp),
            ) {
                Box {
                    CoilImage(
                        modifier = Modifier.fillMaxSize(),
                        imageModel = { comic.series.resourceURI },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.FillHeight
                        ),
                        component = rememberImageComponent {
                            // shows a shimmering effect when loading an image.
                            +ShimmerPlugin(
                                baseColor = Color.Gray,
                                highlightColor = Color.White
                            )
                        }
                    )
                    Text(
                        text = comic.series.name,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp),
                        color = Color.White,
                    )
                }
            }
        }
    }
}