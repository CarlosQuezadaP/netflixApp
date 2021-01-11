package com.instaleap.netflixapp.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.core.Resource
import com.instaleap.domain.models.SerieDomain
import com.instaleap.usecases.IGetSeriesByGenreUseCase
import kotlinx.coroutines.*

class SeriesViewModels(
    private val iGetSeriesByGenreUseCase: IGetSeriesByGenreUseCase
) : ViewModel() {

    var series = MutableLiveData<List<SerieDomain>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)
    var isLoading = ObservableBoolean()
    var failure = ObservableBoolean()


    fun getSeries(page: Int, genreId: Int = 0) {
        isLoading.set(true)
        failure.set(false)
        job = coroutineScope.launch {
            val response = iGetSeriesByGenreUseCase.invoke(page, genreId)
            withContext(Dispatchers.Main) {
                isLoading.set(false)
                when (response) {
                    is Resource.Success -> {
                        series.value = response.value
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