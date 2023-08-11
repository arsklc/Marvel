package com.kilica.marvelmobven.data.dependencyinjection

import com.kilica.marvelmobven.data.datasource.ComicApiDataSource
import com.kilica.marvelmobven.data.datasource.CreatorApiDataSource
import com.kilica.marvelmobven.data.datasource.EventApiDataSource
import com.kilica.marvelmobven.data.datasource.HeroApiDataSource
import com.kilica.marvelmobven.data.datasource.SeriesApiDataSource
import com.kilica.marvelmobven.data.datasource.StoryApiDataSource
import com.kilica.marvelmobven.data.repository.ComicRepositoryImpl
import com.kilica.marvelmobven.data.repository.CreatorRepositoryImpl
import com.kilica.marvelmobven.data.repository.EventRepositoryImpl
import com.kilica.marvelmobven.data.repository.HeroRepositoryImpl
import com.kilica.marvelmobven.data.repository.SeriesRepositoryImpl
import com.kilica.marvelmobven.data.repository.StoryRepositoryImpl
import com.kilica.marvelmobven.domain.repository.ComicRepository
import com.kilica.marvelmobven.domain.repository.CreatorRepository
import com.kilica.marvelmobven.domain.repository.EventRepository
import com.kilica.marvelmobven.domain.repository.HeroRepository
import com.kilica.marvelmobven.domain.repository.SeriesRepository
import com.kilica.marvelmobven.domain.repository.StoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideHeroRepository(dataSource: HeroApiDataSource): HeroRepository {
        return HeroRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideComicRepository(dataSource: ComicApiDataSource): ComicRepository {
        return ComicRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideCreatorRepository(dataSource: CreatorApiDataSource): CreatorRepository {
        return CreatorRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideEventRepository(dataSource: EventApiDataSource): EventRepository {
        return EventRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideSeriesRepository(dataSource: SeriesApiDataSource): SeriesRepository {
        return SeriesRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideStoriesRepository(dataSource: StoryApiDataSource): StoryRepository {
        return StoryRepositoryImpl(dataSource)
    }

}