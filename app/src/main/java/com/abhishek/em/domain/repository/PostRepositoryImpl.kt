package com.abhishek.em.domain.repository

import com.abhishek.em.data.remote.ApiResponse
import com.abhishek.em.data.remote.ApiService
import com.abhishek.em.domain.model.PostDto
import com.abhishek.em.domain.model.UserRequest
import com.abhishek.em.domain.model.UserResponse
import com.abhishek.em.utils.Network
import com.abhishek.em.utils.safeApiFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepositoryImpl(
    private val api: ApiService
) : PostRepository {
    override suspend fun getPosts(): Flow<Network<List<PostDto>>> = flow {
        emit(Network.Loading())
        emit(Network.Success(api.getPosts()))
    }

    override suspend fun registerUser(userRequest: UserRequest): Flow<Network<ApiResponse<UserResponse>>> {
        return safeApiFlow { api.registerUser(userRequest) }
    }
}