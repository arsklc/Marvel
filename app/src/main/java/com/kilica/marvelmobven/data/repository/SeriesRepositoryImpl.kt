package com.kilica.marvelmobven.data.repository

import com.kilica.marvelmobven.data.datasource.SeriesApiDataSource
import com.kilica.marvelmobven.data.mapper.Mapper.mapToSeriesList
import com.kilica.marvelmobven.data.mapper.Mapper.toSeries
import com.kilica.marvelmobven.domain.model.Series
import com.kilica.marvelmobven.domain.repository.SeriesRepository
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val dataSource: SeriesApiDataSource
) : SeriesRepository {
    override suspend fun getAllSeries(offset: Int): List<Series> {
        return dataSource.getSeries(offset = offset.toString()).mapToSeriesList()
    }

    override suspend fun getSeriesById(id: String): Series {
        return dataSource.getSeriesDetails(id).toSeries()
    }
}

