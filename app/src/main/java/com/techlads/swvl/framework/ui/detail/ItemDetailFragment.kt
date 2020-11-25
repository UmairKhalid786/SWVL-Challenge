package com.techlads.swvl.framework.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.techlads.swvl.R
import com.techlads.swvl.data.entities.MoviesResponse

class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: MoviesResponse.Data.Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = it.getParcelable(ARG_ITEM)
                activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title = item?.title
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.findViewById<TextView>(R.id.item_detail).text = it.title
        }

        return rootView
    }

    companion object {
        const val ARG_ITEM = "item_id"
    }
}