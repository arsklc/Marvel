package com.kilica.marvelmobven.domain.dependencyinjection

import com.kilica.marvelmobven.domain.repository.ComicRepository
import com.kilica.marvelmobven.domain.repository.CreatorRepository
import com.kilica.marvelmobven.domain.repository.EventRepository
import com.kilica.marvelmobven.domain.repository.HeroRepository
import com.kilica.marvelmobven.domain.repository.SeriesRepository
import com.kilica.marvelmobven.domain.repository.StoryRepository
import com.kilica.marvelmobven.domain.use_case.get_comic_detail.GetComicDetailUseCase
import com.kilica.marvelmobven.domain.use_case.get_comics.GetComicUseCase
import com.kilica.marvelmobven.domain.use_case.get_creator_detail.GetCreatorDetailUseCase
import com.kilica.marvelmobven.domain.use_case.get_creators.GetCreatorUseCase
import com.kilica.marvelmobven.domain.use_case.get_event_detail.GetEventDetailUseCase
import com.kilica.marvelmobven.domain.use_case.get_events.GetEventUseCase
import com.kilica.marvelmobven.domain.use_case.get_hero_detail.GetHeroDetailUseCase
import com.kilica.marvelmobven.domain.use_case.get_heroes.GetHeroUseCase
import com.kilica.marvelmobven.domain.use_case.get_series.GetSeriesUseCase
import com.kilica.marvelmobven.domain.use_case.get_series_detail.GetSeriesDetailUseCase
import com.kilica.marvelmobven.domain.use_case.get_stories.GetStoriesUseCase
import com.kilica.marvelmobven.domain.use_case.get_story_detail.GetStoryDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideHeroDetailUseCase(
        repository: HeroRepository
    ): GetHeroDetailUseCase {
        return GetHeroDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideHeroUseCase(
        repository: HeroRepository
    ): GetHeroUseCase {
        return GetHeroUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideComicDetailUseCase(
        repository: ComicRepository
    ): GetComicDetailUseCase {
        return GetComicDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideComicUseCase(
        repository: ComicRepository
    ): GetComicUseCase {
        return GetComicUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCreatorDetailUseCase(
        repository: CreatorRepository
    ): GetCreatorDetailUseCase {
        return GetCreatorDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCreatorUseCase(
        repository: CreatorRepository
    ): GetCreatorUseCase {
        return GetCreatorUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideEventDetailUseCase(
        repository: EventRepository
    ): GetEventDetailUseCase {
        return GetEventDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideEventUseCase(
        repository: EventRepository
    ): GetEventUseCase {
        return GetEventUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSeriesDetailUseCase(
        repository: SeriesRepository
    ): GetSeriesDetailUseCase {
        return GetSeriesDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSeriesUseCase(
        repository: SeriesRepository
    ): GetSeriesUseCase {
        return GetSeriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideStoriesDetailUseCase(
        repository: StoryRepository
    ): GetStoryDetailUseCase{
        return GetStoryDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideStoriesUseCase(
        repository: StoryRepository
    ): GetStoriesUseCase {
        return GetStoriesUseCase(repository)
    }
}