package com.instaleap.netflixapp.fragments

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.activities.ListActivity
import com.instaleap.netflixapp.adapters.MoviesAdapter
import com.instaleap.netflixapp.databinding.FragmentMoviesBinding
import com.instaleap.netflixapp.handlers.INavigateToList
import com.instaleap.netflixapp.handlers.OnMovieClick
import com.instaleap.netflixapp.viewmodels.MovieByGenreViewModel
import kotlinx.android.synthetic.main.custom_toolbar_movies_series.view.*
import kotlinx.android.synthetic.main.fragment_movies.view.*
import org.koin.android.ext.android.inject


private const val REQUEST_CODE = 222
private const val DATA_ID = "ID"
private const val DATA_NAME = "GENRE_NAME"

class fragmentMovies : Fragment(), INavigateToList, View.OnClickListener, OnMovieClick {

    val movieByGenreViewModel: MovieByGenreViewModel by inject()
    lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private var genreId = 0
    private var genreName = ""
    lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentMoviesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movies, container, false
        )

        fragmentMoviesBinding.apply {
            onclick = this@fragmentMovies
            type = getString(R.string.movie)
            root.apply {
                include_toolbar.imageViewNetflix.setOnClickListener(this@fragmentMovies)
                include_toolbar.textView_tipe_text.text = "Películas"
            }
        }

        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        getMovies()
    }

    private fun setupAdapter() {
        moviesAdapter = MoviesAdapter(this)
        fragmentMoviesBinding.recyclerViewMovies.apply {
            adapter = moviesAdapter
            postponeEnterTransition()
            viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
        }

    }

    private fun getMovies() {
        movieByGenreViewModel.apply {
            getMovies(1)
            movies.observe(requireActivity(), {
                moviesAdapter.submitList(it)
            })
        }
    }


    override fun onClick(type: String) {
        startActivityForResult(Intent(requireContext(), ListActivity::class.java), REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                genreId = data?.getIntExtra(DATA_ID, 0) ?: 0
                genreName = data?.getStringExtra(DATA_NAME) ?: ""
                updateGenreName(genreName)
                movieByGenreViewModel.getMovies(1, genreId)
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(requireContext(), "Acción cancelada!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updateGenreName(genreName: String) {
        fragmentMoviesBinding.root.include_toolbar.textView_tipe_text.text = genreName
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageViewNetflix -> {
                Navigation.findNavController(v).navigate(R.id.homeFragment)
            }
        }
    }

    override fun onMovieClick(view: View, movieID: Int) {
        val action = fragmentMoviesDirections.actionFragmentMoviesToFragmentDetailMovie(movieID)
        Navigation.findNavController(view).navigate(action)
    }


}