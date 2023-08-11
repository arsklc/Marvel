package com.kilica.marvelmobven.data.repository

import com.kilica.marvelmobven.data.datasource.CreatorApiDataSource
import com.kilica.marvelmobven.data.mapper.Mapper.mapToCreatorList
import com.kilica.marvelmobven.data.mapper.Mapper.toCreator
import com.kilica.marvelmobven.domain.model.Creator
import com.kilica.marvelmobven.domain.repository.CreatorRepository
import javax.inject.Inject

class CreatorRepositoryImpl @Inject constructor(
    private val dataSource: CreatorApiDataSource
) : CreatorRepository {
    override suspend fun getAllCreators(offset: Int): List<Creator> {
        return dataSource.getCreators(offset = offset.toString()).mapToCreatorList()
    }

    override suspend fun getCreatorById(id: String): Creator {
        return dataSource.getCreatorDetails(id).toCreator()
    }
}
