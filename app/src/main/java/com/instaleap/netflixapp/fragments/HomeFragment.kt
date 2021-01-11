package com.instaleap.netflixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.adapters.MainSectionAdapter
import com.instaleap.netflixapp.databinding.FragmentHomeBinding
import com.instaleap.netflixapp.handlers.IClickHomeImage
import com.instaleap.netflixapp.handlers.OnClickHomeItemSection
import com.instaleap.netflixapp.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.custom_toolbar_main.view.*
import kotlinx.android.synthetic.main.error_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), View.OnClickListener, OnClickHomeItemSection, IClickHomeImage,
    IResearch {


    private val homeViewModel: HomeViewModel by inject()
    private lateinit var sectionAdapter: MainSectionAdapter
    private lateinit var homeFragmentBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        homeFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )

        homeFragmentBinding.apply {
            viewModel = homeViewModel
            root.textView_movies_text.setOnClickListener(this@HomeFragment)
            root.textView_series_text.setOnClickListener(this@HomeFragment)
            root.textView_reintent.setOnClickListener(this@HomeFragment)
            homeFragmentBinding.onClickImage = this@HomeFragment
            homeFragmentBinding.research = this@HomeFragment
        }

        configureAdapters()
        getAllSections()


        return homeFragmentBinding.root
    }

    private fun configureAdapters() {

        sectionAdapter = MainSectionAdapter(this)
        homeFragmentBinding.root.recyclerViewMain.adapter = sectionAdapter
    }

    private fun getAllSections() {
        homeViewModel.sections.observe(viewLifecycleOwner, {
            sectionAdapter.submitList(it)
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.textView_movies_text -> {
                Navigation.findNavController(v).navigate(R.id.fragmentMovies)
            }
            R.id.textView_series_text -> {
                Navigation.findNavController(v).navigate(R.id.fragmentSeries)
            }
            R.id.textView_reintent -> {
                getAllSections()
            }
        }
    }

    override fun onClickItemSection(view: View, id: Int, type: String) {
        when (type) {
            getString(R.string.movie) -> {
                val action = HomeFragmentDirections.actionHomeFragmentToFragmentDetailMovie(id)
                Navigation.findNavController(view).navigate(action)
            }

            getString(R.string.serie) -> {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailTvFragment(id)
                Navigation.findNavController(view).navigate(action)
            }

        }
    }

    override fun onClickHomeImage(view: View, movieID: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToFragmentDetailMovie(movieID)
        Navigation.findNavController(view).navigate(action)
    }

    override fun research() {
        homeViewModel.getSections()
    }

}