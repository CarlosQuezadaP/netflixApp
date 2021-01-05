package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.CharacterModel
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.adapters.diff.CharactersItemDiffCallback
import com.instaleap.netflixapp.adapters.viewholder.CharacterViewHolder
import com.instaleap.netflixapp.databinding.MovieItemLayoutBinding

class ChildSectionAdapter :
    ListAdapter<CharacterModel, CharacterViewHolder>(CharactersItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val layout = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item_layout,
            parent,
            false
        ) as MovieItemLayoutBinding

        return CharacterViewHolder(layout)

    }

    override fun onBindViewHolder(holderSection: CharacterViewHolder, position: Int) {
        holderSection.bindTo(getItem(position))
    }

}