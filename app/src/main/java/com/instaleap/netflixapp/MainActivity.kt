package com.instaleap.netflixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.instaleap.netflixapp.viewmodels.UseCasesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val useCasesViewModel: UseCasesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMovies()
    }


    private fun getMovies() {
        useCasesViewModel.movieList.observe(this, {
            val movies = it
            val mo = movies
        })
    }
}