package presentation.utils

import domain.model.DTOMovie

data class HomeUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val top100Movies: List<DTOMovie>? = emptyList(),
)
