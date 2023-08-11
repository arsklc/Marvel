package com.kilica.marvelmobven.data.model.hero

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<İtem>,
    val returned: Int
)