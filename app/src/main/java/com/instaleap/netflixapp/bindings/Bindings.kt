package com.instaleap.netflixapp.bindings

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.netflixapp.Api
import com.instaleap.netflixapp.BuildConfig
import com.instaleap.netflixapp.requestGlideListener


@BindingAdapter("circleImage")
fun loadImageCircle(view: ImageView, imageUrl: String?) {

    val url = "${BuildConfig.IMAGES_URL}$imageUrl"

    Glide.with(view.context)
        .load(url).apply(RequestOptions().circleCrop())
        .into(view)
}


@BindingAdapter("image")
fun loadImage(view: ImageView, imageUrl: String?) {

    val url = "${BuildConfig.IMAGES_URL}$imageUrl"

    Glide.with(view.context)
        .load(url).apply(RequestOptions())
        .into(view)
}


@SuppressLint("SetTextI18n")
@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, releaseDate: MovieDetailDomain?) {
    view.text = "Release Date : ${releaseDate?.release_date}"
}


@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: MovieDetailDomain?) {
    if (movie?.backdrop_path != null) {
        Glide.with(view.context).load(movie?.backdrop_path?.let { Api.getBackdropPath(it) })
            .listener(view.requestGlideListener())
            .into(view)
    } else {
        Glide.with(view.context).load(movie?.poster_path?.let { Api.getBackdropPath(it) })
            .listener(view.requestGlideListener())
            .into(view)
    }
}

