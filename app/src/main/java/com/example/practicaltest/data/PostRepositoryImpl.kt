package com.example.practicaltest.data

import com.example.practicaltest.core.api.ApiService
import com.example.practicaltest.core.api.Post
import com.example.practicaltest.core.util.NetworkResult
import com.example.practicaltest.core.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor (
    private val api: ApiService
):PostRepository {
    override suspend fun getAllPosts(): NetworkResult<List<Post>> {
        return withContext(Dispatchers.IO){
            safeApiCall { api.getAllPosts() }
        }
    }

    override suspend fun getPostById(postId: String): NetworkResult<Post> {
        return withContext(Dispatchers.IO){
            safeApiCall { api.getPostById(postId = postId) }
        }
    }


}