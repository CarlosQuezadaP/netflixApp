package com.instaleap.netflixapp.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.instaleap.domain.CharacterModel
import com.instaleap.domain.SectionModel
import com.instaleap.netflixapp.databinding.MovieItemLayoutBinding

class CharacterViewHolder(private val movieItemLayoutBinding: MovieItemLayoutBinding) :
    RecyclerView.ViewHolder(movieItemLayoutBinding.root) {


     fun bindTo(characterModel: CharacterModel) {
         movieItemLayoutBinding.imageUrl = characterModel.url
    }

}