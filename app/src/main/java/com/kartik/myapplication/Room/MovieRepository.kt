package com.kartik.myapplication.Room

import com.kartik.myapplication.Api.MovieService

class MovieRepository(
    private val movieService: MovieService, private val movieDao: MovieDao) {
    suspend fun getMovies(page: Int, limit: Int): List<MovieEntity> {
        val movies = movieService.getMovies(page, limit).map {
            MovieEntity(
                it.id,
                it.title,
                it.Year,
                it.Runtime,
                it.Cast
            )
        }
        movieDao.insertAll(movies)
        return movies
    }

    suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAll()
    }
}