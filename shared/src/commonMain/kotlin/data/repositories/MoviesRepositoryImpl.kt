package data.repositories

import data.mappers.toDTOMovie
import data.network.response.MovieResponse
import data.network.safeAPICall
import domain.model.DTOMovie
import domain.repositories.IMoviesRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import utils.ResultState

class MoviesRepositoryImpl constructor(
    private val httpClient: HttpClient
) : IMoviesRepository {
    override suspend fun fetchTop100IMDb(): Flow<ResultState<List<DTOMovie>>> {
        return flowOf(
            safeAPICall {
                val response = httpClient.get(urlString = "") {
                }.body<List<MovieResponse>>()
                response.map { it.toDTOMovie() }
            }
        )
    }

    override suspend fun fetchDetail(id: String): Flow<ResultState<DTOMovie>> {
        return flowOf(
            safeAPICall {
                val response = httpClient.get(urlString = id) {
                }.body<MovieResponse>()
                response.toDTOMovie()
            }
        )
    }
}