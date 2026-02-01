package com.example.placementholder

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
data class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)
data class Album(
    val id: Int,
    val title: String,
    val userId: Int
)