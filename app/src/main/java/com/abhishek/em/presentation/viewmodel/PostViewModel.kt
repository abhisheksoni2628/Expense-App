package com.abhishek.em.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.em.domain.model.PostDto
import com.abhishek.em.domain.repository.PostRepository
import com.abhishek.em.utils.Network
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    var posts by mutableStateOf<List<PostDto>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            repository.getPosts().collect { result ->
                when (result) {
                    is Network.Loading -> {
                        isLoading = true
                        errorMessage = null
                    }

                    is Network.Success -> {
                        isLoading = false
                        posts = result.data
                    }

                    is Network.Error -> {
                        isLoading = false
                        errorMessage = result.message
                    }
                }
            }
        }
    }
}