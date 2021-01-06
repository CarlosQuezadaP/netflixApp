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
import com.instaleap.netflixapp.INavigateToList
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.activities.ListActivity
import com.instaleap.netflixapp.adapters.SeriesAdapter
import com.instaleap.netflixapp.databinding.FragmentSeriesBinding
import com.instaleap.netflixapp.viewmodels.SeriesViewModels
import kotlinx.android.synthetic.main.custom_toolbar_movies_series.view.*
import kotlinx.android.synthetic.main.fragment_movies.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val REQUEST_CODE = 222
private const val DATA_ID = "ID"
private const val DATA_NAME = "GENRE_NAME"

class FragmentSeries : Fragment(), INavigateToList, View.OnClickListener {

    val viewModelSeries: SeriesViewModels by viewModel()
    lateinit var fragmentSeriesBinding: FragmentSeriesBinding

    private var genreId = 0
    private var genreName = ""
    lateinit var mRootView: View
    lateinit var seriesAdapter: SeriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSeriesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_series, container, false
        )

        fragmentSeriesBinding.onclick = this
        fragmentSeriesBinding.type = "Series"
        fragmentSeriesBinding.includeToolbar.imageViewNetflix.setOnClickListener(this)
        mRootView = fragmentSeriesBinding.root
        mRootView.include_toolbar.textView_tipe_text.text = "Series"
        viewModelSeries.getSeries(1)
        setAdapter()
        getSeries()
        return mRootView
    }

    private fun setAdapter() {
        seriesAdapter = SeriesAdapter()
        fragmentSeriesBinding.recyclerView.adapter = seriesAdapter
    }

    private fun getSeries() {
        viewModelSeries.series.observe(requireActivity(), {
            seriesAdapter.submitList(it)
        })
    }

    override fun onClick(type: String) {
        startActivityForResult(Intent(requireContext(), ListActivity::class.java), REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                //Obtener por genero
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
        mRootView.include_toolbar.textView_series_text.text = genreName
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageViewNetflix -> {
                Navigation.findNavController(v).navigate(R.id.homeFragment)
            }
        }
    }

}