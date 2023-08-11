package com.kilica.marvelmobven.data.model.comic

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<İtem>,
    val returned: Int
)