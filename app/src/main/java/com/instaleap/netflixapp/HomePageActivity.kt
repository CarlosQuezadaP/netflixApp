package com.instaleap.netflixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.instaleap.netflixapp.viewmodels.UseCasesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePageActivity : AppCompatActivity() {


    private val useCasesViewModel: UseCasesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNavigation()

        getMovies()
    }

    private fun setNavigation() {
        bottom_navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.page_1 -> {

                }
                R.id.page_2 -> {

                }
                R.id.page_3 -> {

                }
                R.id.page_4 -> {

                }
                R.id.page_5 -> {

                }
            }
        }
    }


    private fun getMovies() {
        useCasesViewModel.movieList.observe(this, {

        })
    }
}