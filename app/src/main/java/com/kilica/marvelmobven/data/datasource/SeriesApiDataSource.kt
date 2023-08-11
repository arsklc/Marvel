package com.kilica.marvelmobven.data.datasource

import com.kilica.marvelmobven.data.model.series.SeriesDTO
import com.kilica.marvelmobven.network.api.SeriesAPI
import com.kilica.marvelmobven.util.Constants
import javax.inject.Inject

class SeriesApiDataSource @Inject constructor(
    private val api: SeriesAPI
) {
    suspend fun getSeries(offset: String): SeriesDTO {
        return api.getAllSeries(
            offset = offset,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }

    suspend fun getSeriesDetails(seriesId: String): SeriesDTO {
        return api.getSeriesById(
            seriesId = seriesId,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }
}