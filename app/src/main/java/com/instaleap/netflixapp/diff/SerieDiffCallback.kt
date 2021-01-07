package com.instaleap.netflixapp.diff

import androidx.recyclerview.widget.DiffUtil
import com.instaleap.domain.models.SerieDomain

class SerieDiffCallback : DiffUtil.ItemCallback<SerieDomain>() {

    override fun areItemsTheSame(oldItem: SerieDomain, newItem: SerieDomain): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SerieDomain, newItem: SerieDomain): Boolean =
        oldItem == newItem
}