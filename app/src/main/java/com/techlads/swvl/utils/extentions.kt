package com.techlads.swvl.utils

import android.opengl.Visibility
import android.view.View


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.utils
 */


fun View.visibility(visibility: Boolean){
    this.visibility = if(visibility) View.VISIBLE else View.GONE
}