package com.instaleap.netflixapp.diff

import androidx.recyclerview.widget.DiffUtil
import com.instaleap.domain.CharacterModel

class CharactersItemDiffCallback : DiffUtil.ItemCallback<CharacterModel>() {

    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean =
        oldItem == newItem
}