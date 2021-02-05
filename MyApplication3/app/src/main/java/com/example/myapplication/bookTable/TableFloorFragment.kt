package com.example.myapplication.bookTable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

//tableVPAdapter에서 사용
class TableFloorFragment():Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.booktable_floorfragment, container, false)
        bind(view)
        return view
    }


    public fun bind(view:View){

    }
}