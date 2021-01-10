package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.core.Resource
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.usecases.IGetAllMoviesGenresUseCase
import kotlinx.coroutines.*

class GenresMovieViewModel(private val iGetAllMoviesGenresUseCase: IGetAllMoviesGenresUseCase)
    : ViewModel() {

    var moviesGenres = MutableLiveData<List<GenreItemDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        getAllMoviesGenres()
    }

    private fun getAllMoviesGenres() {
        job = coroutineScope.launch {
            val response = iGetAllMoviesGenresUseCase.invoke()
            withContext(Dispatchers.Main) {
                when (response) {
                    is Resource.Success -> {
                        moviesGenres.value = response.value
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