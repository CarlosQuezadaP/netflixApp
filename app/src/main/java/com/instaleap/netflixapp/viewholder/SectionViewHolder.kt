package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.SectionModel
import com.instaleap.netflixapp.adapters.ChildSectionAdapter
import com.instaleap.netflixapp.databinding.SectionRowBinding
import com.instaleap.netflixapp.fragments.OnClickHomeItemSection

class SectionViewHolder(
    private val sectionRowBinding: SectionRowBinding,
    private val onClickHomeItemSection: OnClickHomeItemSection
) :
    RecyclerView.ViewHolder(sectionRowBinding.root) {

    fun bindTo(section: SectionModel) {
        sectionRowBinding.textViewSectionTitle.text = section.name
        val childSectionAdapter = ChildSectionAdapter(onClickHomeItemSection)
        childSectionAdapter.submitList(section.characters)
        sectionRowBinding.recyclerViewChild.adapter = childSectionAdapter
    }
}



