package com.example.myapplication.bookTable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R


class TableFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 TableFragment", "onCreateView")
        var view = inflater.inflate(R.layout.booktable_fragment, container, false)
        bind(view)
        return view
    }

    //뷰페이저에 어댑터 연결
    public fun bind(view:View){
        Log.d("확인 TableFragment", "bind")
        var vp = view.findViewById<ViewPager2>(R.id.tableVP)
        var vpAdapter = TableVPAdapter(this.getActivity()!!)
        vp.adapter=vpAdapter


    }

}