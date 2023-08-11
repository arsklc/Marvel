package com.kilica.marvelmobven.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
@Composable
fun StatisticsBar(statisticValue: Int) {
    val lineHeight = 20.dp
    val lineWidth = 2.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(lineHeight),
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        repeat(statisticValue) {
            Spacer(
                modifier = Modifier
                    .height(lineHeight)
                    .width(lineWidth)
                    .background(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCustomStatisticsBar() {
    StatisticsBar(statisticValue = 25)
}
