package com.ruzzante.moviesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruzzante.moviesflix.framework.api.MovieRestApiTask
import com.ruzzante.moviesflix.data.MovieRepository
import com.ruzzante.moviesflix.domain.Movie
import com.ruzzante.moviesflix.implementations.MovieDataSourceImplementation
import com.ruzzante.moviesflix.usecase.MovieListUseCase

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieListViewModel"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList


    fun init(){
        getAllMovies()
    }
    private fun getAllMovies(){
        Thread{
            try{
                _moviesList.postValue(movieListUseCase.invoke())
            }catch(ex:Exception){
                Log.d(TAG, ex.message.toString())
            }
        }.start()

    }
}