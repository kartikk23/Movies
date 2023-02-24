package com.kartik.myapplication.Api

import com.kartik.myapplication.Model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieService {
    private val retrofit = Retrofit.Builder()
    .baseUrl("http://task.auditflo.in/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    private val api = retrofit.create(MovieApi::class.java)

    suspend fun getMovies(page: Int, limit: Int): List<Movie> {
        return api.getMovies(page, limit)
    }
}