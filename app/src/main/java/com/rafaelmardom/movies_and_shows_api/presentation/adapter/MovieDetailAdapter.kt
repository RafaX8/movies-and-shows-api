package com.rafaelmardom.movies_and_shows_api.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.movies_and_shows_api.R
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase
import com.rafaelmardom.movies_and_shows_api.domain.GetMoviesFeedUseCase

class MovieDetailAdapter: RecyclerView.Adapter<MovieDetailViewHolder>() {

    private val dataItems = mutableListOf<GetMovieDetailUseCase.MovieDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDetailViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.view_item_movie_feed,
                parent,
                false
            )

        return MovieDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieDetailViewHolder, position: Int) {
        holder.bind(dataItems[position])
    }

    override fun getItemCount() = dataItems.size

}