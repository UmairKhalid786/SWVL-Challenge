package com.techlads.swvl.framework.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.MoviesResponse
import com.techlads.swvl.framework.common.BaseActivity
import com.techlads.swvl.framework.ui.detail.ItemDetailFragment.Companion.ARG_ITEM
import com.techlads.swvl.utils.AppBarStateChangeListener
import com.techlads.swvl.utils.visibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.thumb_img.*

@AndroidEntryPoint
class MovieDetailActivity : BaseActivity(R.layout.activity_item_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
    }

    companion object {

        fun getInstance(ctx: Context, movie: MoviesResponse.Data.Movie): Intent {
            val intent = Intent(ctx, MovieDetailActivity::class.java)
            intent.putExtra(ARG_ITEM, movie)
            return intent
        }
    }

    override fun init() {
        val fragment = ItemDetailFragment.getInstance(movie = intent.getParcelableExtra(ARG_ITEM)!!)
        supportFragmentManager.beginTransaction()
            .add(R.id.item_detail_container, fragment)
            .commit()
    }

    override fun listeners() {
        appBar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                thumbContainer.visibility(state != State.COLLAPSED)
                thumbIv.visibility(state == State.COLLAPSED)
            }
        })
    }

    override fun getToolbar(): Toolbar {
        return detailToolbar
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}