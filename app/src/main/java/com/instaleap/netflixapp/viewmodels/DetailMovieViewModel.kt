package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.core.Resource
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.usecases.IGetMovieDetailUseCase
import kotlinx.coroutines.*

class DetailMovieViewModel(
    private val iGetMovieDetailUseCase: IGetMovieDetailUseCase
) : ViewModel() {

    var movieDetail = MutableLiveData<MovieDetailDomain>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    protected fun getMovie(movieId: Int) {
        job = coroutineScope.launch {
            val response = iGetMovieDetailUseCase.invoke(movieId)
            withContext(Dispatchers.Main) {
                when (response) {
                    is Resource.Success -> {
                        movieDetail.value = response.value
                    }
                    is Resource.Failure -> {

                    }
                }

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}