package com.example.practicaltest.core.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId:String ):Response<Post>

}