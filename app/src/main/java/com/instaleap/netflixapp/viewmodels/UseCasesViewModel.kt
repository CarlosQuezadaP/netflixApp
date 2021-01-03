package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.usecases.IGetAllMoviesUseCase
import kotlinx.coroutines.*

class UseCasesViewModel(private val iGetAllMoviesUseCase: IGetAllMoviesUseCase) : ViewModel() {

    var movieList = MutableLiveData<List<MovieItemDomain>>()
    var movieGenresList = MutableLiveData<List<GenreItemDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    init {

    }

    private fun getMovies() {
        job = coroutineScope.launch {
            val response = iGetAllMoviesUseCase.invoke(1)
            withContext(Dispatchers.Main) {
                movieList.value = response
            }
        }
    }

    private fun getMoviesGenres(){
        job = coroutineScope.launch {
            val response = iGetAllMoviesUseCase.invoke(1)
            withContext(Dispatchers.Main) {
                movieList.value = response
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}