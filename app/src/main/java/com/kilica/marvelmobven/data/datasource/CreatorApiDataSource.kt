package com.kilica.marvelmobven.data.datasource

import com.kilica.marvelmobven.data.model.creator.CreatorsDTO
import com.kilica.marvelmobven.network.api.CreatorAPI
import com.kilica.marvelmobven.util.Constants
import javax.inject.Inject

class CreatorApiDataSource @Inject constructor(
    private val api: CreatorAPI
) {
    suspend fun getCreators(offset: String): CreatorsDTO {
        return api.getAllCreators(
            offset = offset,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }

    suspend fun getCreatorDetails(creatorId: String): CreatorsDTO {
        return api.getCreatorById(
            creatorId = creatorId,
            ts = Constants.getTimeStamp(),
            hash = Constants.hash()
        )
    }
}
