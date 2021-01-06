package com.instaleap.netflixapp.diff

import androidx.recyclerview.widget.DiffUtil
import com.instaleap.domain.models.TVDomain

class SerieDiffCallback : DiffUtil.ItemCallback<TVDomain>() {

    override fun areItemsTheSame(oldItem: TVDomain, newItem: TVDomain): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TVDomain, newItem: TVDomain): Boolean =
        oldItem == newItem
}