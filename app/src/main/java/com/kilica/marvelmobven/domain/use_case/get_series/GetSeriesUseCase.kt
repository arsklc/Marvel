package com.kilica.marvelmobven.domain.use_case.get_series

import com.kilica.marvelmobven.domain.model.Series
import com.kilica.marvelmobven.domain.repository.SeriesRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.net.UnknownHostException
import javax.inject.Inject

class GetSeriesUseCase @Inject constructor(
    private val repository: SeriesRepository
) {

    fun executeGetSeries(offset: Int): Flow<Resource<List<Series>>> = flow {
        try {
            emit(Resource.Loading())
            val seriesList = repository.getAllSeries(offset = offset)
            emit(Resource.Success(seriesList))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        } catch (e: UnknownHostException) {
            emit(Resource.Error(message = e.message ?: ""))
        }
    }
}