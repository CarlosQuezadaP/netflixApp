package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.CharacterModel
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.SectionItemLayoutBinding
import com.instaleap.netflixapp.diff.CharactersItemDiffCallback
import com.instaleap.netflixapp.handlers.OnClickHomeItemSection
import com.instaleap.netflixapp.viewholder.CharacterViewHolder

class ChildSectionAdapter(private val onClickHomeItemSection: OnClickHomeItemSection) :
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
        val characterModel = getItem(position)
        holderSection.apply {
            bindTo(characterModel)
            itemView.setOnClickListener {
                onClickHomeItemSection.onClickItemSection(
                    it,
                    characterModel.id,
                    characterModel.type
                )
            }
        }
    }

}