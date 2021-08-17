package com.ruzzante.moviesflix.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ruzzante.moviesflix.R
import com.ruzzante.moviesflix.domain.Movie
import com.ruzzante.moviesflix.framework.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Instancia do ViewModel
        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        loadingVisibility(true)
        initObserver()
    }

    private fun initObserver(){
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()){
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>){
        moviesList.apply{
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
    private fun loadingVisibility(isLoading: Boolean){
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}