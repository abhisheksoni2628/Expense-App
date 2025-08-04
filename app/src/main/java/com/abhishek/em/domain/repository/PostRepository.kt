package com.abhishek.em.domain.repository

import com.abhishek.em.data.remote.ApiResponse
import com.abhishek.em.domain.model.PostDto
import com.abhishek.em.domain.model.UserRequest
import com.abhishek.em.domain.model.UserResponse
import com.abhishek.em.utils.Network
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPosts(): Flow<Network<List<PostDto>>>
    suspend fun registerUser(userRequest: UserRequest): Flow<Network<ApiResponse<UserResponse>>>
}