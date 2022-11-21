package com.rafaelmardom.movies_and_shows_api.presentation.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.app.extensions.loadUrl
import com.rafaelmardom.movies_and_shows_api.databinding.ViewItemMovieFeedBinding
import com.rafaelmardom.movies_and_shows_api.domain.GetMoviesFeedUseCase

class MovieViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(
    view
){
    fun bind (movie : GetMoviesFeedUseCase.MovieFeed, onClick: ((String) -> Unit)?) {
        val binding = ViewItemMovieFeedBinding.bind(view)
        binding.movieTitle.text = movie.title
        binding.movieGenre.text = movie.genre
        binding.movieRating.text = movie.rating.toString() // Este es double
        // ANTES DE HACER ESTO: CREAR UNA CLASE PARA USAR EL REPOSITORIO GLIDE.
        binding.moviePoster.loadUrl(movie.poster)
        view.setOnClickListener {
            Log.d("@dev", "entra")
            //onClick?.invoke(movie.id) // NO PUEDO PONER ESTO ?
            onClick?.invoke(movie.id)
        }
    }
}