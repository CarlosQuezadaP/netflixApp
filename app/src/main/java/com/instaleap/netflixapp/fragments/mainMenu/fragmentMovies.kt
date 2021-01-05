package com.instaleap.netflixapp.fragments.mainMenu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.instaleap.netflixapp.INavigateToList
import com.instaleap.netflixapp.ListActivity
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.FragmentMoviesBinding
import com.instaleap.netflixapp.viewmodels.GenresMovieUseCaseViewModel
import kotlinx.android.synthetic.main.custom_toolbar_movies_series.view.*
import kotlinx.android.synthetic.main.fragment_movies.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class fragmentMovies : Fragment(), INavigateToList {

    lateinit var content: View
    val genresMovieUseCaseViewModel: GenresMovieUseCaseViewModel by viewModel()
    lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    lateinit var mRootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentMoviesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movies, container, false
        )
        fragmentMoviesBinding.onclick = this
        fragmentMoviesBinding.type = "Movie"

        mRootView = fragmentMoviesBinding.root


        mRootView.include_toolbar.textView_tipe_text.text = "Películas"


        return mRootView
    }


    override fun onClick(type: String) {
        requireContext().startActivity(
            Intent(requireContext(), ListActivity::class.java)
        )
    }


}