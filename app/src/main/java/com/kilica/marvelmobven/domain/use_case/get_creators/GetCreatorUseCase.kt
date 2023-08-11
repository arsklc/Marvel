package com.kilica.marvelmobven.domain.use_case.get_creators

import com.kilica.marvelmobven.domain.model.Creator
import com.kilica.marvelmobven.domain.repository.CreatorRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.net.UnknownHostException
import javax.inject.Inject

class GetCreatorUseCase @Inject constructor(
    private val repository: CreatorRepository
) {

    fun executeGetCreators(offset: Int): Flow<Resource<List<Creator>>> = flow {
        try {
            emit(Resource.Loading())
            val creatorList = repository.getAllCreators(offset = offset)
            emit(Resource.Success(creatorList))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        } catch (e: UnknownHostException) {
            emit(Resource.Error(message = e.message ?: ""))
        }

    }
}
