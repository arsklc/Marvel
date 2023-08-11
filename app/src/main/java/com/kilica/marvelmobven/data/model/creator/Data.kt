package com.kilica.marvelmobven.data.model.creator

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CreatorResult>,
    val total: Int
)