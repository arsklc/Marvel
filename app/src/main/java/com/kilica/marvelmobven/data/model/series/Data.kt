package com.kilica.marvelmobven.data.model.series

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<SeriesResult>,
    val total: Int
)