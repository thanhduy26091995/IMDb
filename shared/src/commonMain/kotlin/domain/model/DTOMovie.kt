package domain.model

data class DTOMovie(
    val rank: Int = 0,
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val bigImage: String = "",
    val genre: List<String> = emptyList(),
    val thumbnail: String = "",
    val rating: String = "",
    val id: String = "",
    val year: Int = 0,
    val imdbId: String = "",
    val imdbLink: String = ""
)
