package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.CharacterModel
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.diff.CharactersItemDiffCallback
import com.instaleap.netflixapp.viewholder.CharacterViewHolder
import com.instaleap.netflixapp.databinding.SectionItemLayoutBinding

class ChildSectionAdapter :
    ListAdapter<CharacterModel, CharacterViewHolder>(CharactersItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val layout = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.section_item_layout,
            parent,
            false
        ) as SectionItemLayoutBinding

        return CharacterViewHolder(layout)

    }

    override fun onBindViewHolder(holderSection: CharacterViewHolder, position: Int) {
        holderSection.bindTo(getItem(position))
    }

}