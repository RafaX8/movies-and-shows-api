package com.rafaelmardom.movies_and_shows_api.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelmardom.movies_and_shows_api.domain.GetMovieDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    val movieDetailState: MutableLiveData<MovieDetailState> by lazy{
        MutableLiveData<MovieDetailState>()
    }

    fun loadMovieDetails(movieId: String){
        movieDetailState.value = MovieDetailState(isLoading = true)
        viewModelScope.launch (Dispatchers.IO) {
            getMovieDetailUseCase.execute(movieId).apply {
                movieDetailState.postValue(MovieDetailState(
                    this,
                    false
                    )
                )
            }
        }
    }

    data class MovieDetailState(
        val movieDetail: GetMovieDetailUseCase.MovieDetail? = null,
        val isLoading : Boolean = true
    )
}