package com.instaleap.netflixapp.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.core.Resource
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.usecases.IGetMoviesByGenreUseCase
import kotlinx.coroutines.*

class MovieByGenreViewModel(
    private val iGetMoviesByGenreUseCase: IGetMoviesByGenreUseCase
) : ViewModel() {

    var movies = MutableLiveData<List<MovieItemDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)
    var isLoading = ObservableBoolean()
    var failure = ObservableBoolean()


    fun getMovies(page: Int, genreId: Int = 0) {
        isLoading.set(true)
        failure.set(false)
        job = coroutineScope.launch {
            val response = iGetMoviesByGenreUseCase.invoke(page, genreId)
            withContext(Dispatchers.Main) {
                isLoading.set(false)
                when (response) {
                    is Resource.Success -> {
                        movies.value = response.value
                    }
                    is Resource.Failure -> {
                        failure.set(true)
                        return@withContext
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