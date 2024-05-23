package com.example.practicaltest.ui.screens.products

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaltest.HttpClient.NetworkResult
import com.example.practicaltest.dataclass.Post
import com.example.practicaltest.repository.ProductServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

data class AllProductsScreenState(
    val posts: List<Post> = emptyList()
)

@HiltViewModel
class AllProductsScreenViewModel @Inject constructor(
    private val productServices: ProductServices
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllProductsScreenState())
    val uiState = _uiState.asStateFlow()

    @SuppressLint("BinaryOperationInTimber")
    fun fetchProduct() {
        Timber.tag("---Fetch Profile Details  ---").w("---Fetch Profile Details ---")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                productServices.getAllProducts().flowOn(Dispatchers.IO)
                    .catch { error ->
                        Timber.tag("getAllProducts error Response").w(error)
                    }
                    .collect { result ->
                        when (result) {
                            is NetworkResult.Success -> {
                                _uiState.update { it.copy(posts = result.data!!) }
                            }

                            is NetworkResult.Error -> {

                            }
                            is NetworkResult.Unauthorized -> {

                            }
                        }
                    }

            }catch (_:Exception){
                Timber.tag("exception in getAllProducts ").w("exception in getAllProducts")

            }finally {

            }

        }
    }

}