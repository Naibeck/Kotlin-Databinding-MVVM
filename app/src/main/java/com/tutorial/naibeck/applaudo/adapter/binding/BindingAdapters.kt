package com.tutorial.naibeck.applaudo.adapter.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Alex Gomez on 5/29/2017.
 */
@BindingAdapter("app:imageUrl")
fun loadImageUrl(view: ImageView, url: String) = with(view) {
    Picasso.with(context)
            .load(url)
            .into(view)
}