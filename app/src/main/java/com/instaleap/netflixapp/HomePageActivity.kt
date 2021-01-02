package com.instaleap.netflixapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.instaleap.netflixapp.databinding.ActivityHomePageBinding
import com.instaleap.netflixapp.viewmodels.UseCasesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePageActivity : AppCompatActivity() {


    private val useCasesViewModel: UseCasesViewModel by viewModel()
    lateinit var homePageBinding: ActivityHomePageBinding

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(
            setOf(
                R.id.homeFragment,
                R.id.fragmentMovies,
                R.id.fragmentSeries,
            )
        ).build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePageBinding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(homePageBinding.root)
        setSupportActionBar(tlb_main)

        setupActionBarWithNavController(navController, appBarConfiguration)
        button_navigation.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {

                }
                R.id.fragmentMovies -> {

                }
                R.id.fragmentSeries -> {

                }
                else -> button_navigation.visibility = View.GONE
            }
        }

    }

    override fun onResume() {
        super.onResume()
        getMovies()
    }

    private fun getMovies() {
        useCasesViewModel.movieList.observe(this, {

        })
    }
}