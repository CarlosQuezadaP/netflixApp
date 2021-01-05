package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.SectionModel
import com.instaleap.usecases.IGetAllModelsSections
import kotlinx.coroutines.*

class MovieUseCase(
    private val iGetAllModelsSections: IGetAllModelsSections
) : ViewModel() {

    var sections = MutableLiveData<List<SectionModel>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        getSections()
    }


    private fun getSections() {
        job = coroutineScope.launch {
            val response = iGetAllModelsSections.invoke(1)
            withContext(Dispatchers.Main) {
                sections.value = response
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}