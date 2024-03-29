package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.netflixapp.databinding.PortadaItemBinding

class MovieViewHolder(private val movieItemBinding: PortadaItemBinding) :
    RecyclerView.ViewHolder(movieItemBinding.root) {

    fun bindTo(movie: MovieItemDomain) {
        movieItemBinding.imageUrl = movie.posterPath
    }


}



