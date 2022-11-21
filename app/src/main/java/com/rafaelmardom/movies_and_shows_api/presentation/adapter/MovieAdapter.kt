package com.rafaelmardom.movies_and_shows_api.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.movies_and_shows_api.R
import com.rafaelmardom.movies_and_shows_api.domain.GetMoviesFeedUseCase

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {

    private val dataItems = mutableListOf<GetMoviesFeedUseCase.MovieFeed>()
    private var itemClick: ((String) -> Unit)? = null

    fun setItemClick(onClick: (String) -> Unit) {
        this.itemClick = onClick
    }

    fun setDataItems(movies: List<GetMoviesFeedUseCase.MovieFeed>) {
        dataItems.clear()
        dataItems.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.view_item_movie_feed,
                parent,
                false
            )

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount() = dataItems.size

}