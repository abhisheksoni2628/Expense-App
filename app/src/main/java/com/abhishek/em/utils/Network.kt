package com.abhishek.em.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

sealed class Network<T> {
    class Loading<T> : Network<T>()
    data class Success<T>(val data: T) : Network<T>()
    data class Error<T>(val message: String) : Network<T>()
}

fun <T> safeApiFlow(apiCall: suspend () -> Response<T>): Flow<Network<T>> = flow {
    emit(Network.Loading())
    try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                emit(Network.Success(body))
            } else {
                emit(Network.Error("Empty response body"))
            }
        } else {
            val errorBody = response.errorBody()?.string()
            emit(Network.Error(errorBody ?: "Unknown API error"))
        }
    } catch (e: Exception) {
        emit(Network.Error(e.localizedMessage ?: "Unexpected error"))
    }
}
