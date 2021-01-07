package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.models.SerieDetailDomain
import com.instaleap.usecases.IGetSerieDetailUseCase
import kotlinx.coroutines.*

class DetailSerieViewModel(
    private val iGetSerieDetailUseCase: IGetSerieDetailUseCase
) : ViewModel() {

    var serieDetail = MutableLiveData<SerieDetailDomain>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    fun getSerieDetail(movieId: Int) {
        job = coroutineScope.launch {
            val response = iGetSerieDetailUseCase.invoke(movieId)
            withContext(Dispatchers.Main) {
                serieDetail.value = response
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}