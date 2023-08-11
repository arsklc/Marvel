package com.kilica.marvelmobven.presentation.homepage.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kilica.marvelmobven.domain.model.Series
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeriesListRow(
    series: Series,
    onItemClick: (Series) -> Unit
) {
    Card(
        onClick = {
            onItemClick(series)
        },
        modifier = Modifier
            .size(140.dp, 230.dp)
            .padding(8.dp),
    ) {
        Box {
            CoilImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = {series.seriesimageUrl},
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
                text = series.title,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                color = Color.White
            )
        }
    }
}