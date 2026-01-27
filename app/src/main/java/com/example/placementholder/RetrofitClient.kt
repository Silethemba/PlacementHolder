package com.example.placementholder
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private  const val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val logging = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY) // Set the desired log level

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging) // Add logging as an application interceptor
        // Add other network interceptors or timeouts here
        .build()
    private val gson = GsonBuilder()
        .setStrictness(Strictness.LENIENT)
        .create()

    //create retrofit instance
    val retrofit by lazy {
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
    }
    val placeHolderClient = retrofit.create<PlaceHolderApi>()
}