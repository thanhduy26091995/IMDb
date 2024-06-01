package data.mappers

import data.network.response.MovieResponse
import domain.model.DTOMovie

fun MovieResponse.toDTOMovie(): DTOMovie {
    with(this) {
        return DTOMovie(
            rank = rank ?: 0,
            title = title ?: "",
            description = description ?: "",
            image = image ?: "",
            bigImage = bigImage ?: "",
            genre = genre ?: emptyList(),
            thumbnail = thumbnail ?: "",
            rating = rating ?: "",
            id = id ?: "",
            year = year ?: 0,
            imdbId = imdbId ?: "",
            imdbLink = imdbLink ?: ""
        )
    }
}