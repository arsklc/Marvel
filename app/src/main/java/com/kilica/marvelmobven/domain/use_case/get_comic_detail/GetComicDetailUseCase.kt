package com.kilica.marvelmobven.domain.use_case.get_comic_detail

import com.kilica.marvelmobven.domain.model.Comic
import com.kilica.marvelmobven.domain.repository.ComicRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetComicDetailUseCase @Inject constructor(private val repository: ComicRepository) {

    fun executeGetComicDetail(id:String): Flow<Resource<Comic>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getComicById(id)))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        }
    }
}