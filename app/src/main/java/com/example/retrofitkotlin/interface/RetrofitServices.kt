package com.example.retrofitkotlin.`interface`

import com.example.retrofitkotlin.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("marvel")
    fun getMovieList() : Call<MutableList<Movie>>
}