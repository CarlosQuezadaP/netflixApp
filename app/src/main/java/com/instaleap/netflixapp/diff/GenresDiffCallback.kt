package com.instaleap.netflixapp.diff

import androidx.recyclerview.widget.DiffUtil
import com.instaleap.domain.models.GenreItemDomain

class GenresDiffCallback : DiffUtil.ItemCallback<GenreItemDomain>() {

    override fun areItemsTheSame(oldItem: GenreItemDomain, newItem: GenreItemDomain): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GenreItemDomain, newItem: GenreItemDomain): Boolean =
        oldItem == newItem
}