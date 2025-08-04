package com.abhishek.em.data.remote

data class ApiResponse<T>(
    val status: Boolean,
    val message: String,
    val response: T?
)
