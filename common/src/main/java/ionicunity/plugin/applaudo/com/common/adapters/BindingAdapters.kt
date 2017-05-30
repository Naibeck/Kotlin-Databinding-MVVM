package ionicunity.plugin.applaudo.com.common.adapters

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Alex Gomez on 5/29/2017.
 */
@BindingAdapter("app:imgUrl")
fun loadImageUrl(imageView: ImageView, url: String) = with(imageView) {
    Picasso.with(context)
            .load(url)
            .into(imageView)
}