package presentation.home

import domain.repositories.IMoviesRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.utils.HomeUiState
import utils.isLoading
import utils.onFailure
import utils.onSuccess

class HomeViewModel constructor(
    private val movieRepository: IMoviesRepository
) {

    private val _homeUiState = MutableStateFlow(HomeUiState(isLoading = true))
    val homeUiState = _homeUiState.asStateFlow()

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _homeUiState.update { it.copy(isLoading = false, error = exception.message) }
    }

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch(coroutineExceptionHandler) {
            movieRepository.fetchTop100IMDb().collectLatest { result ->
                result.isLoading { isLoading ->
                    _homeUiState.update { it.copy(isLoading = isLoading) }
                }.onSuccess { movies ->
                    _homeUiState.update { it.copy(top100Movies = movies) }
                }.onFailure { exception ->
                    _homeUiState.update { it.copy(error = exception.message) }
                }
            }
        }
    }
}