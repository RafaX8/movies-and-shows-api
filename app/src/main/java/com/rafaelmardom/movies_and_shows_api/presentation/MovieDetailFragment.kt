package com.rafaelmardom.movies_and_shows_api.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelmardom.app.extensions.loadUrl
import com.rafaelmardom.movies_and_shows_api.R
import com.rafaelmardom.movies_and_shows_api.databinding.FragmentMovieDetailBinding
import com.rafaelmardom.movies_and_shows_api.presentation.adapter.MovieDetailAdapter

//<!-- TEST -> BORRAR DESPUES -->
class MovieDetailFragment : Fragment() {

    private var viewModel: MovieDetailViewModel? = null
    private var binding: FragmentMovieDetailBinding? = null
    private val movieDetailAdapter = MovieDetailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView(){
        binding?.apply {
            movieDetailFragment.movieGenre.text = getText(R.string.sample_genre)
            movieDetailFragment.moviePlot.text = getText(R.string.sample_plot)
            movieDetailFragment.movieRating.text = getText(R.string.sample_rating)
            movieDetailFragment.movieYear.text = getText(R.string.sample_year)
            movieDetailFragment.movieTitle.text = getText(R.string.sample_title)
            movieDetailFragment.moviePosterCard.loadUrl("")
        }
    }

    // TERMINAR ESTO
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MovieFactory().getMoviesDetailViewModel(requireContext())
        // setupObservers ()  ??????
        //viewModel?.loadMovieDetails(arguments?.getString("key_movie_id") ?: "")
    }

}