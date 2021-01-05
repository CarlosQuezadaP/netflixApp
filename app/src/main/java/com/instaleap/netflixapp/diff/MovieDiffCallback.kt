package com.instaleap.netflixapp.diff

import androidx.recyclerview.widget.DiffUtil
import com.instaleap.domain.models.MovieItemDomain

class MovieDiffCallback : DiffUtil.ItemCallback<MovieItemDomain>() {

    override fun areItemsTheSame(oldItem: MovieItemDomain, newItem: MovieItemDomain): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieItemDomain, newItem: MovieItemDomain): Boolean =
        oldItem == newItem
}