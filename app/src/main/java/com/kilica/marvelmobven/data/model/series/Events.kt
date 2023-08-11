package com.kilica.marvelmobven.data.model.series

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<İtem>,
    val returned: Int
)