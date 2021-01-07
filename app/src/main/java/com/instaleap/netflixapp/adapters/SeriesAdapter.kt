package com.instaleap.netflixapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.instaleap.domain.models.SerieDomain
import com.instaleap.netflixapp.R
import com.instaleap.netflixapp.databinding.PortadaItemBinding
import com.instaleap.netflixapp.diff.SerieDiffCallback
import com.instaleap.netflixapp.handlers.OnserieClick
import com.instaleap.netflixapp.viewholder.SerieViewHolder

class SeriesAdapter(private val onserieClick: OnserieClick) :
    ListAdapter<SerieDomain, SerieViewHolder>(SerieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {

        val layout = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.portada_item,
            parent,
            false
        ) as PortadaItemBinding

        return SerieViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {

        holder.apply {
            bindTo(getItem(position))
            itemView.setOnClickListener {
                onserieClick.onClicl(it, getItem(position).id)
            }

        }
    }


}
