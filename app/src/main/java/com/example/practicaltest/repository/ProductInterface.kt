package com.example.practicaltest.repository

import com.example.practicaltest.HttpClient.NetworkResult
import com.example.practicaltest.dataclass.Post
import kotlinx.coroutines.flow.Flow

interface ProductServices {

    suspend fun getAllProducts(): Flow<NetworkResult<List<Post>>>

    suspend fun getProductById(postId:String): Flow<NetworkResult<Post>>

}