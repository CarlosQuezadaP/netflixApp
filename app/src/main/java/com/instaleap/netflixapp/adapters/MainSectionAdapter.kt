package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.SectionModel
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.SectionRowBinding
import com.instaleap.netflixapp.diff.SectionItemDiffCallback
import com.instaleap.netflixapp.fragments.OnClickHomeItemSection
import com.instaleap.netflixapp.viewholder.SectionViewHolder

class MainSectionAdapter(private val onClickHomeItemSection: OnClickHomeItemSection) :
    ListAdapter<SectionModel, SectionViewHolder>(SectionItemDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {

        val layout = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.section_row,
            parent,
            false
        ) as SectionRowBinding

        return SectionViewHolder(layout, onClickHomeItemSection)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }


}