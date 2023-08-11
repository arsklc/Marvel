package com.kilica.marvelmobven.domain.use_case.get_series_detail

import com.kilica.marvelmobven.domain.model.Series
import com.kilica.marvelmobven.domain.repository.SeriesRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(private val repository: SeriesRepository) {

    fun executeGetSeriesDetail(id:String): Flow<Resource<Series>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getSeriesById(id)))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        }
    }
}