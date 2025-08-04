package com.abhishek.em.data.remote

import com.abhishek.em.domain.model.PostDto
import com.abhishek.em.domain.model.User
import com.abhishek.em.domain.model.UserRequest
import com.abhishek.em.domain.model.UserResponse
import com.abhishek.em.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @POST(Constants.register)
    suspend fun registerUser(
        @Body userDto: UserRequest
    ): Response<ApiResponse<UserResponse>>
}