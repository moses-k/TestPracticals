package com.example.practicaltest.ui.screens.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaltest.core.api.Post
import com.example.practicaltest.core.util.NetworkResult
import com.example.practicaltest.data.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AllProductsScreenState(
    val posts: List<Post> = emptyList()
)

@HiltViewModel
class AllProductsScreenViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllProductsScreenState())
    val uiState = _uiState.asStateFlow()

    fun fetchProduct() {
        viewModelScope.launch {
            val response = postRepository.getAllPosts()
            when (response) {
                is NetworkResult.Success -> {
                    _uiState.update { it.copy(posts = response.data) }
                }

                is NetworkResult.Error -> {

                }

                is NetworkResult.Exception -> {

                }
            }
        }
    }

}