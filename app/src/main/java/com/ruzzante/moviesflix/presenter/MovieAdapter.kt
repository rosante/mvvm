package com.ruzzante.moviesflix.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruzzante.moviesflix.R
import com.ruzzante.moviesflix.domain.Movie
import kotlinx.android.synthetic.main.movie_item_layout.view.*
import coil.load

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            movieTitle.text = moviesList[position].titulo
            movieImage.
            movieImage.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_movie)
                fallback(R.drawable.ic_movie)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size


}

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)