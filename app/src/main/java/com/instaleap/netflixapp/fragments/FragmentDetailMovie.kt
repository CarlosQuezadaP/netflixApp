package com.instaleap.netflixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.applyToolbarMargin
import com.instaleap.netflixapp.databinding.FragmentDetailMovieBinding
import com.instaleap.netflixapp.viewmodels.DetailMovieViewModel
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*
import org.koin.android.ext.android.inject

class FragmentDetailMovie : Fragment() {

    private val args: FragmentDetailMovieArgs by navArgs()
    val moviedetailViewModel: DetailMovieViewModel by inject()
    lateinit var fragmentDetailBinding: FragmentDetailMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_movie, container, false
        )
        fragmentDetailBinding.apply {
            lifecycleOwner = this@FragmentDetailMovie
            viewModel = moviedetailViewModel
        }
        return fragmentDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        observeMovieDetail()
    }

    private fun observeMovieDetail() {
        moviedetailViewModel.apply {
            getMovie(args.idMovie)
            movieDetail.observe(viewLifecycleOwner, {
                fragmentDetailBinding.detailHeaderTitle.text = it.title
                movie_detail_toolbar.title = it.title
            })
        }
    }

    private fun initializeUI() {
        applyToolbarMargin(movie_detail_toolbar)
    }


}