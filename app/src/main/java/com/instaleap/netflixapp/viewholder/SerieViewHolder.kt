package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.models.TVDomain
import com.instaleap.netflixapp.databinding.PortadaItemBinding

class SerieViewHolder(private val movieItemBinding: PortadaItemBinding) :
    RecyclerView.ViewHolder(movieItemBinding.root) {

    fun bindTo(serie: TVDomain) {
        movieItemBinding.imageUrl = serie.poster_path
    }


}



