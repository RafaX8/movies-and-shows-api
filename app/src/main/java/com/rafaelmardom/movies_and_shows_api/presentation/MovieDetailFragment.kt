package com.rafaelmardom.movies_and_shows_api.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.faltenreich.skeletonlayout.Skeleton
import com.rafaelmardom.app.extensions.loadUrl
import com.rafaelmardom.movies_and_shows_api.databinding.FragmentMovieDetailBinding
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase

class MovieDetailFragment : Fragment() {

    private var viewModel: MovieDetailViewModel? = null
    private var binding: FragmentMovieDetailBinding? = null
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MovieFactory().getMoviesDetailViewModel(requireContext())
        setupObservers ()
        viewModel?.loadMovieDetails(arguments?.getString("movieId") ?: "error")
    }

    private fun setupView(){
        binding?.apply {
            skeleton = skeletonDetail
        }
    }
    private fun setupObservers() {
        val movieDetailsState = Observer<MovieDetailViewModel.MovieDetailState> { state ->
            if (state.isLoading) {
                skeleton?.showSkeleton()
            } else {
                skeleton?.showOriginal()
                state.movieDetail?.let {
                        bind(it)
                    }
                }
            }
        viewModel?.movieDetailState?.observe(viewLifecycleOwner, movieDetailsState)
    }

    private fun bind(model: GetMovieDetailUseCase.MovieDetail) {
        binding?.apply {
            movieGenre.text = model.genre
            moviePlot.text = model.plot
            movieYear.text = model.year
            movieTitle.text = model.title
            moviePoster.loadUrl(model.poster)
            movieRating.text = model.rating.toString()
        }
    }
}