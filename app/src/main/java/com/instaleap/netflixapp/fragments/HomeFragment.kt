package com.instaleap.netflixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.adapters.MainSectionAdapter
import com.instaleap.netflixapp.handlers.OnClickHomeItemSection
import com.instaleap.netflixapp.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.custom_toolbar_main.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), View.OnClickListener, OnClickHomeItemSection {


    val homeViewModel: HomeViewModel by inject()
    lateinit var content: View
    lateinit var sectionAdapter: MainSectionAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        content = inflater.inflate(R.layout.fragment_home, container, false)

        configureAdapters()
        getAllSections()

        content.textView_movies_text.setOnClickListener(this)
        content.textView_series_text.setOnClickListener(this)


        return content
    }

    private fun configureAdapters() {

        sectionAdapter = MainSectionAdapter(this)
        content.recyclerViewMain.adapter = sectionAdapter
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

}