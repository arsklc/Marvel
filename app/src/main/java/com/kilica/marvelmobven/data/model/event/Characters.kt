package com.kilica.marvelmobven.data.model.event

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<İtem>,
    val returned: Int
)