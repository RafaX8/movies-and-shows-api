package com.rafaelmardom.movies_and_shows_api.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rafaelmardom.app.extensions.loadUrl
import com.rafaelmardom.movies_and_shows_api.databinding.ViewItemMovieDetailBinding
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase

class MovieDetailViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(
    view
){
    fun bind (movie : GetMovieDetailUseCase.MovieDetail) {
        val binding = ViewItemMovieDetailBinding.bind(view)
        binding.movieTitle.text = movie.title
        binding.movieGenre.text = movie.genre
        binding.movieRating.text = movie.rating.toString() // Este es double
        binding.moviePlot.text = movie.plot
        binding.movieYear.text = movie.year
        // ANTES DE HACER ESTO: CREAR UNA CLASE PARA USAR EL REPOSITORIO GLIDE.
        binding.moviePosterCard.loadUrl(movie.poster)

    }
}