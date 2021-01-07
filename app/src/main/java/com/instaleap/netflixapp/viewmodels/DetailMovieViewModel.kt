package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.usecases.IGetMovieDetailUseCase
import kotlinx.coroutines.*

class DetailMovieViewModel(
    private val iGetMovieDetailUseCase: IGetMovieDetailUseCase
) : ViewModel() {

    var movieDetail = MutableLiveData<MovieDetailDomain>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    fun getMovie(movieId: Int) {
        job = coroutineScope.launch {
            val response = iGetMovieDetailUseCase.invoke(movieId)
            withContext(Dispatchers.Main) {
                movieDetail.value = response
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}