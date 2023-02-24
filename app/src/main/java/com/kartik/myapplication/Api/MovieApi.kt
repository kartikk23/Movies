package com.kartik.myapplication.Api

import com.kartik.myapplication.Model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("1.json")
    suspend fun getMovies(@Query("page") page: Int, @Query("limit") limit: Int): List<Movie>
}

