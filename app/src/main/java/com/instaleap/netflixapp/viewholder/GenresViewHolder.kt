package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.netflixapp.databinding.GenresItemLayoutBinding

class GenresViewHolder(private val genresItemLayoutBinding: GenresItemLayoutBinding) :
    RecyclerView.ViewHolder(genresItemLayoutBinding.root) {
    fun bindTo(genre: GenreItemDomain) {
        genresItemLayoutBinding.genre = genre.name
    }
}



