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

    @GET("posts/{id}")
    fun editPlaceHolderPosts(): Call<Post?>

    @GET("/comments/3")
    fun getPlaceHolderComments(): Call<Comment?>

    @GET("/albums/5")
    fun getPlaceHolderAlbums(): Call<Album?>

    @POST("/posts")
    fun postPlaceHolderPosts(@Body post: Post): Call<Post?>

    @PATCH("posts/{id}")
    fun patchPlaceHolderPost(@Path("id") id: Int, @Body post: Post): Call<Post?>

    @PUT("posts/{id}")
    fun putPlaceHolderPost(@Path("id") id: Int, @Body post: Post): Call<Post?>

    @DELETE("posts/{id}")
    fun deletePlaceHolderPost(@Path("id") id: Int): Call<Post?>
}



