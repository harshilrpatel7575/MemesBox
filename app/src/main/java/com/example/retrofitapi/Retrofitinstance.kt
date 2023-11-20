package com.example.retrofitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitinstance {

    val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://meme-api.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    val ApiInstance by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}