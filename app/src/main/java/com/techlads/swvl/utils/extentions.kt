package com.techlads.swvl.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.techlads.swvl.R
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.util.*


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.utils
 */


fun View.visibility(visible: Boolean){
    this.visibility = if(visible) View.VISIBLE else View.GONE
}

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToParent: Boolean = false) : View {
    return LayoutInflater.from(context).inflate(layout, this, attachToParent)
}

fun Context.showMessage(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun View.fadeIn(){
    val fadeIn = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator() //add this
    fadeIn.duration = 1000

    fadeIn.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {

        }

        override fun onAnimationEnd(animation: Animation) {
            visibility(false)
        }

        override fun onAnimationRepeat(animation: Animation) {

        }
    })


   /* this.animate()
        .translationY(0f)
        .alpha(0.0f)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                visibility(false)
            }
        })*/
}


fun ImageView.loadImage(
    url: String,
    defaultImg: Int = R.mipmap.ic_launcher
) {

    Picasso.get().load(url).placeholder(defaultImg).error(defaultImg).into(this)
}
