package com.example.myapplication.bookTable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.bookTime.BookData
import com.example.myapplication.bookTime.BookTime

//BookTime에서 사용
class TableFragment: Fragment() {
    lateinit var bookData:BookData
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 TableFragment", "onCreateView")
        var view = inflater.inflate(R.layout.booktable_fragment, container, false)


        bind(view)
        return view
    }

    //뷰페이저에 어댑터 연결
    public fun bind(view:View){
        Log.d("확인 TableFragment", "bind")
        var bundle = getArguments()
        if (bundle != null) bookData = bundle.getSerializable("bookData") as BookData
        else{
            Log.d("확인 TimeFragment.bind", "else")
        }
        //뷰페이저
        var vp = view.findViewById<ViewPager2>(R.id.tableVP)
        var vpAdapter = TableVPAdapter(this.getActivity()!!, bookData)
        vp.adapter=vpAdapter

        var completeButton = view.findViewById<Button>(R.id.tableCompleteButton)
        completeButton.setOnClickListener {
            Log.d("확인 TableFragment", "BookTime의 bookTimeActivity호출")
            var bookTimeActivity= activity as BookTime
            bookTimeActivity.replaceMenuFragment()
        }

    }



}