package com.ruzzante.moviesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {
    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
}