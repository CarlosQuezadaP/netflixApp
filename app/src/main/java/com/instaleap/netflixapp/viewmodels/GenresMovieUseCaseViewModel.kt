package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.usecases.IGetMoviesGenres
import kotlinx.coroutines.*

class GenresMovieUseCaseViewModel(private val iGetMoviesGenres: IGetMoviesGenres) : ViewModel() {


    var moviesGenres = MutableLiveData<List<GenreItemDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        getAllMoviesGenres()
    }

    private fun getAllMoviesGenres() {
        job = coroutineScope.launch {
            val response = iGetMoviesGenres.invoke()
            withContext(Dispatchers.Main) {
                moviesGenres.value = response
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}