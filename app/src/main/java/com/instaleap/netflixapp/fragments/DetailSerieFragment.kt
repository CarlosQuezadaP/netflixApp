package com.instaleap.netflixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.FragmentDetailSerieBinding
import com.instaleap.netflixapp.viewmodels.DetailSerieViewModel
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*
import org.koin.android.ext.android.inject

class DetailSerieFragment : Fragment() {

    private val args: DetailSerieFragmentArgs by navArgs()
    lateinit var detailSerieBinding: FragmentDetailSerieBinding
    val detailSerieViewModel: DetailSerieViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        detailSerieBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_serie, container, false
        )
        detailSerieBinding.apply {
            lifecycleOwner = this@DetailSerieFragment
            viewModelDetailSerie = detailSerieViewModel
        }
        return detailSerieBinding.root
    }

    private fun getSeriedetail() {
        detailSerieViewModel.apply {
            getSerieDetail(args.idSerie)
            serieDetail.observe(viewLifecycleOwner, {
                detailSerieBinding.detailHeaderTitle.text = it.name
                movie_detail_toolbar.title = it.name
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSeriedetail()
    }




}