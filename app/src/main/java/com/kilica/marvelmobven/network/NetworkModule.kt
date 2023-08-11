package com.kilica.marvelmobven.network

import android.content.Context
import com.kilica.marvelmobven.data.datasource.ComicApiDataSource
import com.kilica.marvelmobven.data.datasource.CreatorApiDataSource
import com.kilica.marvelmobven.data.datasource.EventApiDataSource
import com.kilica.marvelmobven.data.datasource.HeroApiDataSource
import com.kilica.marvelmobven.data.datasource.SeriesApiDataSource
import com.kilica.marvelmobven.data.datasource.StoryApiDataSource
import com.kilica.marvelmobven.network.api.ComicAPI
import com.kilica.marvelmobven.network.api.CreatorAPI
import com.kilica.marvelmobven.network.api.EventAPI
import com.kilica.marvelmobven.network.api.HeroAPI
import com.kilica.marvelmobven.network.api.SeriesAPI
import com.kilica.marvelmobven.network.api.StoryAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @MarvelRetrofitInstance
    @Provides
    @Singleton
    fun provideMarvelRetrofitInstance(@ApplicationContext context: Context, @MarvelBaseUrl baseUrl: String): MarvelMobvenRetrofit {
        return MarvelMobvenRetrofit(context, baseUrl)
    }

    @MarvelBaseUrl
    @Provides
    @Singleton
    fun provideMarvelBaseUrl(): String {
        return NetworkConstants.MARVEL_BASE_URL
    }

    @Provides
    @Singleton
    fun provideHeroApi(@MarvelRetrofitInstance retrofitInstance: MarvelMobvenRetrofit): HeroAPI {
        return retrofitInstance.create(HeroAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideHeroApiDataSource(api: HeroAPI): HeroApiDataSource {
        return HeroApiDataSource(api)
    }
    @Provides
    @Singleton
    fun provideComicApi(@MarvelRetrofitInstance retrofitInstance: MarvelMobvenRetrofit): ComicAPI {
        return retrofitInstance.create(ComicAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideComicApiDataSource(api: ComicAPI): ComicApiDataSource {
        return ComicApiDataSource(api)
    }

    @Provides
    @Singleton
    fun provideCreatorApi(@MarvelRetrofitInstance retrofitInstance: MarvelMobvenRetrofit): CreatorAPI {
        return retrofitInstance.create(CreatorAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideCreatorApiDataSource(api: CreatorAPI): CreatorApiDataSource {
        return CreatorApiDataSource(api)
    }

    @Provides
    @Singleton
    fun provideEventApi(@MarvelRetrofitInstance retrofitInstance: MarvelMobvenRetrofit): EventAPI {
        return retrofitInstance.create(EventAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideEventApiDataSource(api: EventAPI): EventApiDataSource {
        return EventApiDataSource(api)
    }

    @Provides
    @Singleton
    fun provideSeriesApi(@MarvelRetrofitInstance retrofitInstance: MarvelMobvenRetrofit): SeriesAPI {
        return retrofitInstance.create(SeriesAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideSeriesApiDataSource(api: SeriesAPI): SeriesApiDataSource {
        return SeriesApiDataSource(api)
    }

    @Provides
    @Singleton
    fun provideStoryApi(@MarvelRetrofitInstance retrofitInstance: MarvelMobvenRetrofit): StoryAPI{
        return retrofitInstance.create(StoryAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideStoriesApiDataSource(api: StoryAPI): StoryApiDataSource{
        return StoryApiDataSource(api)
    }

    //URL
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class MarvelBaseUrl

    //Retrofit
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class MarvelRetrofitInstance

}