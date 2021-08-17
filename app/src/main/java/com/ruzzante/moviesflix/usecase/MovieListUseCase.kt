package com.ruzzante.moviesflix.usecase

import com.ruzzante.moviesflix.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()
}