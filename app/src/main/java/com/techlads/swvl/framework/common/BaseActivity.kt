package com.techlads.swvl.framework.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_movies_list.*


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.common
 */


abstract class BaseActivity(@LayoutRes val layout : Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setSupportActionBar(getToolbar())
        init()
        listeners()
    }

    abstract fun init()
    abstract fun listeners()
    abstract fun getToolbar() : Toolbar
}