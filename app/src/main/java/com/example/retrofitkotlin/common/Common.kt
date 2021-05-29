package com.example.retrofitkotlin.common

import com.example.retrofitkotlin.`interface`.RetrofitServices
import com.example.retrofitkotlin.retrofit.RetrofitClient

object Common {
    val BASE_URL : String = "https://www.simplifiedcoding.net/demos/"
    val retrofitServices : RetrofitServices?
        get() = RetrofitClient
            .getClient(BASE_URL)
            ?.create(RetrofitServices::class.java)
}