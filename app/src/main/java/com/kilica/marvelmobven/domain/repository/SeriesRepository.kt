package com.kilica.marvelmobven.domain.repository

import com.kilica.marvelmobven.domain.model.Series

interface SeriesRepository {

    suspend fun getAllSeries(offset:Int):List<Series>

    suspend fun getSeriesById(id:String): Series
}
