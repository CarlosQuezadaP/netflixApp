package com.instaleap.netflixapp.fragments.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.instaleap.netflixapp.R
import kotlinx.android.synthetic.main.custom_toolbar_movies_series.view.*


class FragmentSeries : Fragment() {

    lateinit var content: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        content = inflater.inflate(R.layout.fragment_series, container, false)

        content.textView_tipe_text.text = "Series"
        return content
    }

}