package com.example.practicaltest.data

import com.example.practicaltest.core.api.Post
import com.example.practicaltest.core.util.NetworkResult

interface PostRepository {

    suspend fun getAllPosts():NetworkResult<List<Post>>

    suspend fun getPostById(postId:String): NetworkResult<Post>

}