package com.example.myapplication.sikdangChoicePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class SikdangChoiceMenuFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        var View= inflater.inflate(R.layout.sikdangchoice_menu_fragment, container, false)
        bind(View)

        //View.setBackgroundResource(bannerImage)

        return View
    }

    fun bind(itemView:View):View?{


        return itemView

    }
}