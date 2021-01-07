package com.instaleap.netflixapp.bindings

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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


@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, releaseDate: String?) {
    view.text = "Release Date : ${releaseDate ?: "No date."}"
}


@BindingAdapter(value = ["backdrop_path", "poster_path"], requireAll = true)
fun bindBackDrop(view: ImageView, backdrop_path: String?, poster_path: String?) {

    val imageUrl = backdrop_path ?: poster_path ?: ""

    Glide.with(view.context).load(Api.getBackdropPath(imageUrl))
        .listener(view.requestGlideListener())
        .into(view)
}

