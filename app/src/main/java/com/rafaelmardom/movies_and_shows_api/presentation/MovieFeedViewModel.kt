package com.rafaelmardom.movies_and_shows_api.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelmardom.movies_and_shows_api.domain.GetMoviesFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieFeedViewModel(
    private val getMoviesFeedUseCase: GetMoviesFeedUseCase
): ViewModel() {

    val movieFeedData: MutableLiveData<MovieFeedState> by lazy {
        MutableLiveData<MovieFeedState>()
    }

    fun loadMovies() {
        movieFeedData.value = MovieFeedState()

        viewModelScope.launch(Dispatchers.IO) {
            val moviesFeed = getMoviesFeedUseCase.execute()
            movieFeedData.postValue(
                MovieFeedState(moviesFeed)
            )
        }
    }

    data class MovieFeedState(
        val moviesFeed: List<GetMoviesFeedUseCase.MovieFeed> = emptyList()
    )
}