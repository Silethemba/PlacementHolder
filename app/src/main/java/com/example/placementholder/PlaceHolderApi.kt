package com.example.placementholder

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface PlaceHolderApi {
    @GET("/posts/5")
    fun getPlaceHolderPosts(): Call<Post?>

    @GET("/comments/3")
    fun getPlaceHolderComments(): Call<Comment?>

    @GET("/Albums")
    fun getPlaceHolderAlbums(): Call<Album?>

    @POST("/posts")
    fun postPlaceHolderPosts(@Body post: Post): Call<Post?>

    @PATCH("posts/{id}")
    fun patchPost(@Path("id") id: Int, @Body post: Post): Call<Post?>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Void?
}



