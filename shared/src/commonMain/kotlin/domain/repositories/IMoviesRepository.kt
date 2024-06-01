package domain.repositories

import data.network.response.MovieResponse
import domain.model.DTOMovie
import kotlinx.coroutines.flow.Flow
import utils.ResultState

interface IMoviesRepository {
    suspend fun fetchTop100IMDb(): Flow<ResultState<List<DTOMovie>>>

    suspend fun fetchDetail(id: String): Flow<ResultState<DTOMovie>>
}