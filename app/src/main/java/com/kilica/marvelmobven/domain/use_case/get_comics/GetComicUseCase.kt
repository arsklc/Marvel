package com.kilica.marvelmobven.domain.use_case.get_comics

import com.kilica.marvelmobven.domain.model.Comic
import com.kilica.marvelmobven.domain.repository.ComicRepository
import com.kilica.marvelmobven.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.net.UnknownHostException
import javax.inject.Inject

class GetComicUseCase @Inject constructor(
    private val repository: ComicRepository
) {

    fun executeGetComics(offset: Int): Flow<Resource<List<Comic>>> = flow {
        try {
            emit(Resource.Loading())
            val comicList = repository.getAllComics(offset = offset)
            emit(Resource.Success(comicList))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error"))
        } catch (e: UnknownHostException) {
            emit(Resource.Error(message = e.message ?: ""))
        }

    }
}