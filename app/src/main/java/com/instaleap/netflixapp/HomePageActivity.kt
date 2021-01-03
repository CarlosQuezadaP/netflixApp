package com.instaleap.netflixapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.instaleap.netflixapp.databinding.ActivityHomePageBinding
import com.instaleap.netflixapp.viewmodels.UseCasesViewModel
import kotlinx.android.synthetic.main.activity_home_page.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePageActivity : AppCompatActivity() {


    private val useCasesViewModel: UseCasesViewModel by viewModel()
    lateinit var homePageBinding: ActivityHomePageBinding

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homePageBinding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(homePageBinding.root)

        bottom_navigation.setupWithNavController(navController)
    }

    private fun getMovies() {
        useCasesViewModel.movieList.observe(this, {

        })
    }

    private fun getMoviesGenres() {
        useCasesViewModel.movieGenresList.observe(this, {

        })
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}