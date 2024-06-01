package data.network

import utils.ResultState

suspend fun <T : Any?> safeAPICall(apiCall: suspend () -> T): ResultState<T> {
    return try {
        // Loading first
        ResultState.Loading

        ResultState.Success(apiCall.invoke())
    } catch (e: Exception) {
        ResultState.Failure(e)
    }
}