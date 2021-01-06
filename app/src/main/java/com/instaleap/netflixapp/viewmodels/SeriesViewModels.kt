package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.TVDomain
import com.instaleap.usecases.IGetTvsByGenre
import kotlinx.coroutines.*

class SeriesViewModels(
    private val iGetTvsByGenre: IGetTvsByGenre
) : ViewModel() {

    var series = MutableLiveData<List<TVDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    fun getSeries(page: Int, genreId: Int = 0) {
        job = coroutineScope.launch {
            val response = iGetTvsByGenre.invoke(page, genreId)
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