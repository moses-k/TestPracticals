package com.example.practicaltest.ui.screens.product

import androidx.lifecycle.SavedStateHandle
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

data class ProductScreenState(
    val product:Post? = null,
)


@HiltViewModel
class ProductScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val postRepository: PostRepository
):ViewModel() {

    val id = savedStateHandle.get<String>(key = "id") ?: ""

    private var _uiState = MutableStateFlow(ProductScreenState())
    val uiState = _uiState.asStateFlow()


    fun getProductById(){
        viewModelScope.launch {
            val response = postRepository.getPostById(postId = id)
            when(response){
                is NetworkResult.Success -> {
                    _uiState.update { it.copy(product = response.data) }
                }
                is NetworkResult.Error -> {

                }
                is NetworkResult.Exception -> {

                }
            }
        }
    }
}