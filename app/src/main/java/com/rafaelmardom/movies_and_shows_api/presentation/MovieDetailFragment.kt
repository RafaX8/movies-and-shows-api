package com.rafaelmardom.movies_and_shows_api.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.rafaelmardom.app.extensions.loadUrl
import com.rafaelmardom.movies_and_shows_api.databinding.FragmentMovieDetailBinding
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase

class MovieDetailFragment : Fragment() {

    private var viewModel: MovieDetailViewModel? = null
    private var binding: FragmentMovieDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MovieFactory().getMoviesDetailViewModel(requireContext())
        setupObservers ()
        viewModel?.loadMovieDetails(arguments?.getString("movieId") ?: "0") // ESTO ES LO QUE DA ERROR
    }

    private fun setupObservers() {
        val movieDetailsState = Observer<MovieDetailViewModel.MovieDetailState> { state ->
            state.movieDetail?.let {
                bind(it)
            }
        }
        viewModel?.movieDetailState?.observe(viewLifecycleOwner, movieDetailsState)
    }

    private fun bind(model: GetMovieDetailUseCase.MovieDetail) {
        binding?.apply {
            movieDetailFragment.movieGenre.text = model.genre
            movieDetailFragment.moviePlot.text = model.plot
            movieDetailFragment.movieYear.text = model.year
            movieDetailFragment.movieTitle.text = model.title
            movieDetailFragment.moviePoster.loadUrl(model.poster)
            movieDetailFragment.movieRating.text = model.rating.toString()
        }
    }
}