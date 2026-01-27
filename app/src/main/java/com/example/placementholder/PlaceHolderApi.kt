package com.example.placementholder

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlaceHolderApi {
    @GET("/posts/5")
    fun getPlaceHolderPosts(): Call<Post?>

    @GET("/comments")
    fun getPlaceHolderComments(): Call<Comments?>

    @GET("/Albums")
    fun getPlaceHolderAlbums(): Call<Albums?>

    @POST("/posts")
    fun postPlaceHolderPosts(): Call<Post?>

    @POST("posts")
    fun createPost(@Body post: Post): Post

    @PATCH("posts/{id}")
    fun patchPost(@Path("id") id: Int, @Body post: Post): Post

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Void?
}



