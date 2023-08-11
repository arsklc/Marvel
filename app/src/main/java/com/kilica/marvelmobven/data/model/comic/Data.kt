package com.kilica.marvelmobven.data.model.comic

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ComicResult>,
    val total: Int
)