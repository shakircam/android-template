package com.shakircam.android.utils

/**
 * 03/07/2022
 * Created by Shakir
 * Using this class for network call state.
 * It will easily manage our network call statement.
 */

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}
