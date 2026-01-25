package com.example.placementholder

import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderApi {
    @GET("/posts/5")
    fun getPlaceHolderPosts(): Call<Post?> //

    @GET("/comments")
    fun getPlaceHolderComments(): Call<Comments?>

    @GET("/Albums")
    fun getPlaceHolderAlbums(): Call<Albums?>
}
