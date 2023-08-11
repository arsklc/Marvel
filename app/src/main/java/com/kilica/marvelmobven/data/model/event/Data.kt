package com.kilica.marvelmobven.data.model.event

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<EventResult>,
    val total: Int
)