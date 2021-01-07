package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.SectionModel
import com.instaleap.netflixapp.adapters.ChildSectionAdapter
import com.instaleap.netflixapp.databinding.SectionRowBinding
import com.instaleap.netflixapp.handlers.OnClickHomeItemSection

class SectionViewHolder(
    private val sectionRowBinding: SectionRowBinding,
    private val onClickHomeItemSection: OnClickHomeItemSection
) :
    RecyclerView.ViewHolder(sectionRowBinding.root) {

    fun bindTo(section: SectionModel) {
        val childSectionAdapter = ChildSectionAdapter(onClickHomeItemSection)
        childSectionAdapter.submitList(section.characters)
        sectionRowBinding.apply {
            textViewSectionTitle.text = section.name
            recyclerViewChild.adapter = childSectionAdapter
        }
    }
}



