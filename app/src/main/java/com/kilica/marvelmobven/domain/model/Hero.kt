package com.kilica.marvelmobven.domain.model

import com.kilica.marvelmobven.data.model.hero.Comics
import com.kilica.marvelmobven.data.model.hero.Events
import com.kilica.marvelmobven.data.model.hero.Series
import com.kilica.marvelmobven.data.model.hero.Stories

data class Hero(
    val id : Int,
    val name : String,
    val description : String,
    val comics : Comics,
    val events : Events,
    val stories : Stories,
    val series : Series,
    val imageUrl: String,
)

