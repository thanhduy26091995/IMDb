package data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("rank")
    val rank: Int? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("image")
    val image: String? = null,

    @SerialName("big_image")
    val bigImage: String? = null,

    @SerialName("genre")
    val genre: List<String>? = null,

    @SerialName("thumbnail")
    val thumbnail: String? = null,

    @SerialName("rating")
    val rating: String? = null,

    @SerialName("id")
    val id: String? = null,

    @SerialName("year")
    val year: Int? = null,

    @SerialName("imdbid")
    val imdbId: String? = null,

    @SerialName("imdb_link")
    val imdbLink: String? = null
)
