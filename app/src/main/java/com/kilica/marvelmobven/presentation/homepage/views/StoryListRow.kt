package com.kilica.marvelmobven.presentation.homepage.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kilica.marvelmobven.domain.model.Story
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryListRow(
    story : Story,
    onItemClick: (Story) -> Unit
){
    Card(
        onClick = {
            onItemClick(story)
        },
        modifier = Modifier
            .size(140.dp, 230.dp)
            .padding(horizontal = 4.dp,vertical = 4.dp),
    ) {
        Box {
            CoilImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = {story.storyimageUrl},
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
                text = story.title,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                color = Color.White
            )
        }
    }
}