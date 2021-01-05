package com.instaleap.netflixapp.fragments.mainMenu

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
import com.instaleap.netflixapp.INavigateToList
import com.instaleap.netflixapp.ListActivity
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.FragmentMoviesBinding
import kotlinx.android.synthetic.main.custom_toolbar_movies_series.view.*
import kotlinx.android.synthetic.main.fragment_movies.view.*

private const val REQUEST_CODE = 222
private const val DATA_ID = "ID"
private const val DATA_NAME = "GENRE_NAME"
private const val TYPE = "TYPE"

class fragmentMovies : Fragment(), INavigateToList {

    lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    lateinit var mRootView: View
    private var genreId = 0
    private var genreName = ""

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
        startActivityForResult(Intent(requireContext(), ListActivity::class.java), REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                //Obtener por genero
                genreId = data?.getIntExtra(DATA_ID, 0) ?: 0
                genreName = data?.getStringExtra(DATA_NAME) ?: ""
                updateGenreName(genreName)
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(requireContext(), "Acción cancelada!", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun updateGenreName(genreName: String) {
        mRootView.include_toolbar.textView_series_text.text = genreName
    }


}