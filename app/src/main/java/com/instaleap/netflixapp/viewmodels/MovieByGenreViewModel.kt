package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.usecases.IGetMoviesByGenre
import kotlinx.coroutines.*

class MovieByGenreViewModel(
    private val iGetMoviesByGenre: IGetMoviesByGenre
) : ViewModel() {

    var movies = MutableLiveData<List<MovieItemDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    fun getMovies(page: Int, genreId: Int = 0) {
        job = coroutineScope.launch {
            val response = iGetMoviesByGenre.invoke(page, genreId)
            withContext(Dispatchers.Main) {
                movies.value = response
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}