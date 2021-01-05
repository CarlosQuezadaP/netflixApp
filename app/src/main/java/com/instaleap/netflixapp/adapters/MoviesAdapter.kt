package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.MovieItemBinding
import com.instaleap.netflixapp.diff.MovieDiffCallback
import com.instaleap.netflixapp.viewholder.MovieViewHolder

class MoviesAdapter : ListAdapter<MovieItemDomain, MovieViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layout = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        ) as MovieItemBinding

        return MovieViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }


}
