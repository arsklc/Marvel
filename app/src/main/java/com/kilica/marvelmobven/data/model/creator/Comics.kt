package com.kilica.marvelmobven.data.model.creator

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<İtem>,
    val returned: Int
)