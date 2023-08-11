package com.kilica.marvelmobven.data.mapper

import com.kilica.marvelmobven.data.model.comic.ComicResult
import com.kilica.marvelmobven.data.model.comic.ComicsDTO
import com.kilica.marvelmobven.data.model.creator.CreatorResult
import com.kilica.marvelmobven.data.model.creator.CreatorsDTO
import com.kilica.marvelmobven.data.model.event.EventResult
import com.kilica.marvelmobven.data.model.event.EventsDTO
import com.kilica.marvelmobven.data.model.hero.HeroesDTO
import com.kilica.marvelmobven.data.model.hero.Result
import com.kilica.marvelmobven.data.model.series.SeriesDTO
import com.kilica.marvelmobven.data.model.series.SeriesResult
import com.kilica.marvelmobven.data.model.story.StoriesDTO
import com.kilica.marvelmobven.data.model.story.StoryResult
import com.kilica.marvelmobven.domain.model.Comic
import com.kilica.marvelmobven.domain.model.Creator
import com.kilica.marvelmobven.domain.model.Event
import com.kilica.marvelmobven.domain.model.Hero
import com.kilica.marvelmobven.domain.model.Series
import com.kilica.marvelmobven.domain.model.Story

object Mapper {
    fun HeroesDTO.mapToHeroList(): List<Hero> {
        return this.data.results.map {
            it.toHero()
        }
    }

    fun HeroesDTO.toHero(): Hero {
        return this.data.results[0].toHero()
    }

    private fun Result.toHero(): Hero {
        return Hero(
            id = this.id,
            name = this.name,
            description = this.description,
            comics = this.comics,
            events = this.events,
            stories = this.stories,
            series = this.series,
            imageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension,
        )

    }
    fun ComicsDTO.mapToComicList(): List<Comic> {
        return this.data.results.map {
            it.toComic()
        }
    }

    fun ComicsDTO.toComic():Comic{
        return this.data.results[0].toComic()
    }

    private fun ComicResult.toComic() : Comic {
        return try {
            Comic(
                characters = this.characters,
                creators = this.creators,
                description = this.description,
                events = this.events,
                id = this.id,
                series = this.series,
                stories = this.stories,
                title = this.title,
                comicimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        } catch (e: NullPointerException) {
            Comic(
                characters = this.characters,
                creators = this.creators,
                description = "", this.events,
                id = id, series = this.series,
                stories =  this.stories,
                title = this.title,
                comicimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension)
        }
    }

    fun CreatorsDTO.mapToCreatorList(): List<Creator> {
        return this.data.results.map {
            it.toCreator()
        }
    }

    fun CreatorsDTO.toCreator(): Creator {
        return this.data.results[0].toCreator()
    }

    private fun CreatorResult.toCreator() : Creator {
        return try {
            Creator(
                comics = this.comics,
                events = this.events,
                fullName = this.fullName,
                id = this.id,
                series = this.series,
                stories = this.stories,
                creatorimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        } catch (e: NullPointerException) {
            Creator(
                comics = this.comics,
                events = this.events,
                fullName = this.fullName,
                id = this.id,
                series = this.series,
                stories = this.stories,
                creatorimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension)
        }
    }

    fun EventsDTO.mapToEventList(): List<Event> {
        return this.data.results.map {
            it.toEvent()
        }
    }

    fun EventsDTO.toEvent(): Event {
        return this.data.results[0].toEvent()
    }

    private fun EventResult.toEvent() : Event {
        return try {
            Event(
            characters = this.characters,
            comics = this.comics,
            creators = this.creators,
            description = this.description,
            id = this.id,
            series = this.series,
            stories = this.stories,
            title = this.title,
            eventimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        } catch (e: NullPointerException) {
            Event(
                characters = this.characters,
                comics = this.comics,
                creators = this.creators,
                description = this.description,
                id = this.id,
                series = this.series,
                stories = this.stories,
                title = this.title,
                eventimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        }
    }
    fun SeriesDTO.mapToSeriesList(): List<Series>{
        return this.data.results.map{
            it.toSeries()
        }
    }
    fun SeriesDTO.toSeries(): Series {
        return this.data.results[0].toSeries()
    }
    private fun SeriesResult.toSeries() : Series {
        return try{
            Series(
                characters = this.characters,
                comics = this.comics,
                creators = this.creators,
                events = this.events,
                id = this.id,
                stories = this.stories,
                title = this.title,
                seriesimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        }catch (e: NullPointerException) {
            Series(
                characters = this.characters,
                comics = this.comics,
                creators = this.creators,
                events = this.events,
                id = this.id,
                stories = this.stories,
                title = this.title,
                seriesimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        }
    }
    fun StoriesDTO.mapToStoriesList(): List<Story>{
        return this.data.results.map{
            it.toStories()
        }
    }
    fun StoriesDTO.toStories(): Story {
        return this.data.results[0].toStories()
    }
    private fun StoryResult.toStories() : Story {
        return try{
            Story(
                characters = this.characters,
                comics = this.comics,
                creators = this.creators,
                description = this.description,
                events = this.events,
                id = this.id,
                series = this.series,
                title = this.title,
                storyimageUrl = this.thumbnail.path.replace("http", "https") + "." + this.thumbnail.extension
            )
        }catch (e: NullPointerException) {
            Story(
                characters = this.characters,
                comics = this.comics,
                creators = this.creators,
                description = this.description,
                events = this.events,
                id = this.id,
                series = this.series,
                title = this.title,
                storyimageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg"
            )
        }
    }

}