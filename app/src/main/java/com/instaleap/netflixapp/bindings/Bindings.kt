package com.instaleap.netflixapp.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.instaleap.netflixapp.BuildConfig


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