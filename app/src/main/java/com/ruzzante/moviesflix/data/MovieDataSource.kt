package com.ruzzante.moviesflix.data

import com.ruzzante.moviesflix.domain.Movie

interface MovieDataSource {
    fun getAllMovies(): List<Movie>
}