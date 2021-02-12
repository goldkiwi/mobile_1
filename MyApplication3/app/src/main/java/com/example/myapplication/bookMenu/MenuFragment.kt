package com.example.myapplication.bookMenu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTime.BookData

class MenuFragment: Fragment() {
    lateinit var bookData:BookData
    lateinit var menuData:MenuData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater.inflate(R.layout.bookmenu_fragment, container, false)
        var bundle = getArguments()
        if (bundle != null) {
            bookData = bundle.getSerializable("bookData") as BookData
            menuData = bundle.getSerializable("menuData") as MenuData
        }
        else{
            Log.d("확인 TimeFragment.bind", "else")
        }


        bind(view)
        return view
    }
    fun bind(itemView:View){


        //각 테이블별로 어떤 메뉴가 예약 되었는지 표시해주는 리사이클러뷰
        var tableRV : RecyclerView = itemView.findViewById(R.id.tableRV)
        var menuTableRVAdapter = MenuTableRVAdapter(this!!.getActivity()!!, menuData)
        tableRV.adapter = menuTableRVAdapter

        var tableRVLayoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)
        tableRV.layoutManager=tableRVLayoutManager
        tableRV.setHasFixedSize(true)

    }
}