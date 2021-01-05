package com.instaleap.netflixapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.CharacterModel
import com.instaleap.netflixapp.databinding.SectionItemLayoutBinding

class CharacterViewHolder(private val movieItemLayoutBinding: SectionItemLayoutBinding) :
    RecyclerView.ViewHolder(movieItemLayoutBinding.root) {


     fun bindTo(characterModel: CharacterModel) {
         movieItemLayoutBinding.imageUrl = characterModel.url
    }

}