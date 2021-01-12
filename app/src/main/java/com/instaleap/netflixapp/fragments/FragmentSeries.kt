package com.instaleap.netflixapp.fragments

import android.app.Activity
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
import com.instaleap.netflixapp.adapters.SeriesAdapter
import com.instaleap.netflixapp.databinding.FragmentSeriesBinding
import com.instaleap.netflixapp.handlers.INavigateToList
import com.instaleap.netflixapp.handlers.IResearch
import com.instaleap.netflixapp.handlers.OnserieClick
import com.instaleap.netflixapp.viewmodels.SeriesViewModels
import kotlinx.android.synthetic.main.custom_toolbar_movies_series.view.*
import kotlinx.android.synthetic.main.fragment_series.*
import kotlinx.android.synthetic.main.fragment_series.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val REQUEST_CODE = 222
private const val DATA_ID = "ID"
private const val DATA_NAME = "GENRE_NAME"

class FragmentSeries : Fragment(), INavigateToList, View.OnClickListener, OnserieClick, IResearch {

    private val viewModelSeries: SeriesViewModels by viewModel()
    private lateinit var fragmentSeriesBinding: FragmentSeriesBinding

    private var genreId = 0
    private var genreName = ""
    private lateinit var seriesAdapter: SeriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSeriesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_series, container, false
        )

        fragmentSeriesBinding.apply {
            viewModel = viewModelSeries
            onclick = this@FragmentSeries
            research = this@FragmentSeries
            type = getString(R.string.series)
            root.apply {
                include_toolbar_series.textView_tipe_text.text = getString(R.string.series)
                include_toolbar_series.imageViewNetflix.setOnClickListener(
                    this@FragmentSeries
                )
            }
        }

        return fragmentSeriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        getSeries()
    }

    private fun setupAdapter() {
        seriesAdapter = SeriesAdapter(this)
        fragmentSeriesBinding.recyclerView.apply {
            adapter = seriesAdapter
            postponeEnterTransition()
            viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
        }
    }


    private fun getSeries() {
        viewModelSeries.apply {
            getSeries(1)
            series.observe(requireActivity(), {
                seriesAdapter.submitList(it)
            })
        }
    }




    override fun onClick(type: String) {
        startActivityForResult(Intent(requireContext(), ListActivity::class.java), REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                genreId = data?.getIntExtra(DATA_ID, 0) ?: 0
                genreName = data?.getStringExtra(DATA_NAME) ?: ""
                updateGenreName(genreName)
                viewModelSeries.getSeries(1, genreId)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(requireContext(), "Acción cancelada!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updateGenreName(genreName: String) {
        fragmentSeriesBinding.root.include_toolbar_series.textView_genres_text.text = genreName
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageViewNetflix -> {
                Navigation.findNavController(v).navigate(R.id.homeFragment)
            }
        }
    }

    override fun onClicl(view: View, serieId: Int) {
        val action = FragmentSeriesDirections.actionFragmentSeriesToDetailTvFragment(serieId)
        Navigation.findNavController(view).navigate(action)
    }

    override fun research() {
        getSeries()
    }
}