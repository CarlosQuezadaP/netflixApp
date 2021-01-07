package com.instaleap.netflixapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.ActivityHomePageBinding
import kotlinx.android.synthetic.main.activity_home_page.*
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class HomePageActivity : AppCompatActivity() {

    lateinit var homePageBinding: ActivityHomePageBinding

    private val navController: NavController by lazy { findNavController(R.id.fragment_nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        homePageBinding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(homePageBinding.root)
        bottom_navigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


}