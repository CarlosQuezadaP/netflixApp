package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.usecases.IGetAllMoviesUseCase
import kotlinx.coroutines.*

class UseCasesViewModel(private val iGetAllMoviesUseCase: IGetAllMoviesUseCase) : ViewModel() {

    var movieList = MutableLiveData<List<MovieItemDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    init {
        showData()
    }

    private fun showData() {
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