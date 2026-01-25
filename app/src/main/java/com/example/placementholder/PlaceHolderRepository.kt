package com.example.placementholder

import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PlaceHolderRepository {
    fun placeholderNetworkCall(): Post?{

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY) // Set the desired log level

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging) // Add logging as an application interceptor
            // Add other network interceptors or timeouts here
            .build()
        val gson = GsonBuilder()
            .setStrictness(Strictness.LENIENT)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
        val placeHolderClient = retrofit.create<PlaceHolderApi>()
        val apiCall: Call<Post?> = placeHolderClient.getPlaceHolderPosts()
        val placeHolderPostResponse : Response<Post?> = apiCall.execute()
        return placeHolderPostResponse.body()
    }
}

