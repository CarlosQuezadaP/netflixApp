package com.instaleap.netflixapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.domain.SectionModel
import com.instaleap.usecases.IGetAllModelsSectionsUseCase
import kotlinx.coroutines.*

class HomeViewModel(
    private val iGetAllModelsSectionsUseCase: IGetAllModelsSectionsUseCase
) : ViewModel() {

    var sections = MutableLiveData<List<SectionModel>>()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        getSections()
    }


    private fun getSections() {
        job = coroutineScope.launch {
            val response = iGetAllModelsSectionsUseCase.invoke(1)
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