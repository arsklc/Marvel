package com.kilica.marvelmobven.domain.model

data class HeroDetail(
    val id : Int,
    val name : String,
    val description : String,
    val thumbnail : String,
    val thumbnailExt: String,
    val comics : List<String>,
    val events : List<String>,
    val stories : List<String>,
    val series : List<String>,
    val ImageUrl: String = thumbnail+thumbnailExt
)
