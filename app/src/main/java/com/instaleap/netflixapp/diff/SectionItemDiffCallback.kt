package com.instaleap.netflixapp.diff

import androidx.recyclerview.widget.DiffUtil
import com.instaleap.domain.SectionModel

class SectionItemDiffCallback : DiffUtil.ItemCallback<SectionModel>() {

    override fun areItemsTheSame(oldItem: SectionModel, newItem: SectionModel): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: SectionModel, newItem: SectionModel): Boolean =
        oldItem == newItem
}