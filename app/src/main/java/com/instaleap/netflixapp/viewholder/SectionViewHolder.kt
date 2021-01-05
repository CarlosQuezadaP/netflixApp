package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.SectionModel
import com.instaleap.netflixapp.adapters.ChildSectionAdapter
import com.instaleap.netflixapp.databinding.SectionRowBinding

class SectionViewHolder(private val sectionRowBinding: SectionRowBinding) :
    RecyclerView.ViewHolder(sectionRowBinding.root) {

    fun bindTo(section: SectionModel) {
        sectionRowBinding.textViewSectionTitle.text = section.name
        val childSectionAdapter = ChildSectionAdapter()
        childSectionAdapter.submitList(section.characters)
        sectionRowBinding.recyclerViewChild.adapter = childSectionAdapter
    }
}



