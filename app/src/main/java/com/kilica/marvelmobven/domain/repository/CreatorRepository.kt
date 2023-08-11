package com.kilica.marvelmobven.domain.repository

import com.kilica.marvelmobven.domain.model.Creator

interface CreatorRepository {
    suspend fun getAllCreators(offset:Int):List<Creator>

    suspend fun getCreatorById(id:String): Creator
}
