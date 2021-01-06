package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.usecases.IGetMovieDetail
import kotlinx.coroutines.*

class DetailMovieViewModel(
    private val iGetMovieDetail: IGetMovieDetail
) : ViewModel() {

    var movieDetail = MutableLiveData<MovieDetailDomain>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    fun getMovie(movieId: Int) {
        job = coroutineScope.launch {
            val response = iGetMovieDetail.invoke(movieId)
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