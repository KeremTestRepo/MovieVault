package com.necatisozer.movievault.data.source.tmdb.entity

import com.squareup.moshi.JsonClass
import org.threeten.bp.LocalDate

@JsonClass(generateAdapter = true)
data class Movie(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollection?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Int,
    val images: Images,
    val imdb_id: String?,
    val original_language: String,
    val original_title: String,
    val overview: String?,
    val popularity: Double,
    val poster_path: String?,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: LocalDate,
    val revenue: Int,
    val runtime: Int?,
    val spoken_languages: List<SpokenLanguage>,
    val status: Status,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val videos: Videos,
    val vote_average: Double,
    val vote_count: Int
) : TmdbEntity {
    @JsonClass(generateAdapter = true)
    data class ProductionCompany(
        val id: Int,
        val logo_path: String?,
        val name: String,
        val origin_country: String
    ) : TmdbEntity

    @JsonClass(generateAdapter = true)
    data class Videos(
        val results: List<Result>
    ) : TmdbEntity {
        @JsonClass(generateAdapter = true)
        data class Result(
            val id: String,
            val iso_3166_1: String,
            val iso_639_1: String,
            val key: String,
            val name: String,
            val site: String,
            val size: Int,
            val type: String
        ) : TmdbEntity
    }

    @JsonClass(generateAdapter = true)
    data class BelongsToCollection(
        val backdrop_path: String?,
        val id: Int,
        val name: String,
        val poster_path: String?
    ) : TmdbEntity

    @JsonClass(generateAdapter = true)
    data class ProductionCountry(
        val iso_3166_1: String,
        val name: String
    ) : TmdbEntity

    @JsonClass(generateAdapter = true)
    data class Images(
        val backdrops: List<String>,
        val posters: List<String>
    ) : TmdbEntity

    @JsonClass(generateAdapter = true)
    data class Genre(
        val id: Int,
        val name: String
    ) : TmdbEntity

    @JsonClass(generateAdapter = true)
    data class SpokenLanguage(
        val iso_639_1: String,
        val name: String
    ) : TmdbEntity

    enum class Status(val value: String) {
        RUMORED("Rumored"),
        PLANNED("Planned"),
        IN_PRODUCTION("In Production"),
        POST_PRODUCTION("Post Production"),
        RELEASED("Released"),
        CANCELLED("Cancelled")
    }
}