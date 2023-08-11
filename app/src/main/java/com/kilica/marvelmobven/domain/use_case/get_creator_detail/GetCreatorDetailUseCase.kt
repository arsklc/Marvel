package com.kilica.marvelmobven.domain.use_case.get_creator_detail

import com.kilica.marvelmobven.domain.model.Creator
import com.kilica.marvelmobven.domain.repository.CreatorRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetCreatorDetailUseCase @Inject constructor(private val repository: CreatorRepository) {

    fun executeGetCreatorDetail(id:String): Flow<Resource<Creator>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getCreatorById(id)))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        }
    }
}
