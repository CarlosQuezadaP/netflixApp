package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.SerieDomain
import com.instaleap.usecases.IGetSeriesByGenreUseCase
import kotlinx.coroutines.*

class SeriesViewModels(
    private val iGetSeriesByGenreUseCase: IGetSeriesByGenreUseCase
) : ViewModel() {

    var series = MutableLiveData<List<SerieDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    fun getSeries(page: Int, genreId: Int = 0) {
        job = coroutineScope.launch {
            val response = iGetSeriesByGenreUseCase.invoke(page, genreId)
            withContext(Dispatchers.Main) {
                series.value = response
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}