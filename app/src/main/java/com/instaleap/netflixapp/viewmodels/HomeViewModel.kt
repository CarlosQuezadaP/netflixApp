package com.instaleap.netflixapp.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.instaleap.core.Resource
import com.instaleap.domain.CharacterModel
import com.instaleap.domain.SectionModel
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.SerieDomain
import com.instaleap.usecases.IGetPopularMoviesUseCase
import com.instaleap.usecases.IGetPopularSeriesUseCase
import kotlinx.coroutines.*

class HomeViewModel(
    private val iGetPopularMoviesUseCase: IGetPopularMoviesUseCase,
    private val iGetPopularSeriesUseCase: IGetPopularSeriesUseCase
) : ViewModel() {

    var sections = MutableLiveData<List<SectionModel>>()
    var isLoading = ObservableBoolean()
    var failure = ObservableBoolean()
    private var job: Job? = null
    private var coroutineScope = CoroutineScope(Dispatchers.IO)
    val characterModel = ObservableField<CharacterModel>()

    init {
        getSections()
    }

    fun getSections() {
        isLoading.set(true)
        failure.set(false)
        job = coroutineScope.launch {
            val responseMovies = iGetPopularMoviesUseCase.invoke(1)
            val responseSeries = iGetPopularSeriesUseCase.invoke(1)
            withContext(Dispatchers.Main) {
                isLoading.set(false)
                var movies = listOf<MovieItemDomain>()
                var series = listOf<SerieDomain>()
                when (responseMovies) {
                    is Resource.Success -> {
                        movies = responseMovies.value
                    }
                    is Resource.Failure -> {
                        failure.set(true)
                        return@withContext
                    }
                }

                when (responseSeries) {
                    is Resource.Success -> {
                        series = responseSeries.value
                    }
                    is Resource.Failure -> {

                    }
                }
                sections.value = generate(movies, series)
                characterModel.set(sections.value?.get(0)?.characters?.get(0))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    private fun generateMovieSection(
        movies: List<MovieItemDomain>,
    ): SectionModel {
        val moviesModels = movies

        val list = moviesModels.map {
            CharacterModel(it.posterPath, "Movie", it.id)
        }

        return SectionModel("Popular Movies", list)
    }

    private fun generateSerieSection(
        series: List<SerieDomain>,
    ): SectionModel {
        val moviesModels = series

        val list = moviesModels.map {
            CharacterModel(it.poster_path, "Serie", it.id)
        }
        return SectionModel("Popular Series", list)
    }


    fun generate(
        movies: List<MovieItemDomain>,
        series: List<SerieDomain>
    ): List<SectionModel> {
        val sectionMovie =
            generateMovieSection(movies)

        val sectionSerie =
            generateSerieSection(series)

        return listOf(sectionMovie, sectionSerie)
    }


}