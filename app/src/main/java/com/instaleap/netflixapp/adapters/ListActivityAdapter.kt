package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.netflixapp.handlers.ISelectGenre
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.GenresItemLayoutBinding
import com.instaleap.netflixapp.diff.GenresDiffCallback
import com.instaleap.netflixapp.viewholder.GenresViewHolder

class ListActivityAdapter(private val iSelectGenre: ISelectGenre) :
    ListAdapter<GenreItemDomain, GenresViewHolder>(GenresDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {

        val layout = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.genres_item_layout,
            parent,
            false
        ) as GenresItemLayoutBinding

        return GenresViewHolder(layout)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {

        holder.apply {
            bindTo(getItem(position))
            itemView.setOnClickListener {
                iSelectGenre.selectGenre(getItem(position))
            }
        }

    }


}