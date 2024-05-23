package com.example.practicaltest.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)