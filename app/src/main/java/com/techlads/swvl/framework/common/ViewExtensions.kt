package com.techlads.swvl.framework.common

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.common
 */



fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}


fun Activity.displayToast(
    @StringRes message:Int,
){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.displayToast(
    message:String
){
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}
