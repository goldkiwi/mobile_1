package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.widget.LinearLayout

class BannerSlideFragment : Fragment() {
    /*
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View= inflater.inflate(R.layout.banner_fragment, container, false)*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var View= inflater.inflate(R.layout.banner_fragment, container, false)
        return View
    }
}