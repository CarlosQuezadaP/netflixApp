package com.instaleap.netflixapp

import org.junit.Test
import org.junit.Assert.*
import com.instaleap.usecases.IGetPopularMoviesUseCase
import com.instaleap.usecases.repository.IMovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UseCasesTest {

    @InjectMocks
    lateinit var getPopularMoviesUseCase: IGetPopularMoviesUseCase

    @Mock
    lateinit var moviesRepository: IMovieRepository


    @Before
    fun initialization() {
        MockitoAnnotations.initMocks(this)
        Mockito.mock(IMovieRepository::class.java)
    }

    @Before
    fun setUp() {

    }


    @Test
    fun `get all topMovies`() = runBlocking {
        assertEquals(42, 42)

    }
}