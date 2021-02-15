package com.example.myapplication.bookMenu

import android.os.Bundle
import android.os.Parcelable
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
    lateinit var tableNumAR:ArrayList<Int>
    var tableNumString = ""//테이블

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 MenuFragment", "1")
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater.inflate(R.layout.bookmenu_fragment, container, false)
        var bundle = getArguments()
        if (bundle != null) {
            bookData = bundle.getSerializable("bookData") as BookData
            menuData = bundle.getSerializable("menuData") as MenuData
            Log.d("확인 MenuFragment", "2")
            //tableNumAR = (bundle.getParcelableArrayList("tabkeNumAR") as ArrayList<Int>?)!!
            //문제가 인트 리스트가 아니라 문자열로 넘어온다
            val tableNumList = bundle.getParcelableArrayList<Parcelable?>("tableNumAR")as ArrayList<Int>
            Log.d("확인 MenuFragment", "3")
            var i = 0
            var tempString=""
            while (i< tableNumList!!.size){
                Log.d("확인 MenuFragment", tableNumList.size.toString()+" i 반복"+i.toString())
                tempString+=tableNumList[i].toString()
                i++
            }

            Log.d("확인 MenuFragment tableNumAR 넘어왔는지 확인", tempString)
        }
        else{
            Log.d("확인 MenuFragment bundle 받아오기", "else")
        }
        Log.d("확인 MenuFragment", "2")


        bind(view)
        return view
    }
    fun bind(itemView:View){
        Log.d("확인 MenuFragment.bind", "1")


        //각 테이블별로 어떤 메뉴가 예약 되었는지 표시해주는 리사이클러뷰
        var tableRV : RecyclerView = itemView.findViewById(R.id.tableRV)
        var menuTableRVAdapter = MenuTableRVAdapter(this!!.getActivity()!!, menuData)
        tableRV.adapter = menuTableRVAdapter
        Log.d("확인 MenuFragment.bind", "2")

        var tableRVLayoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)
        tableRV.layoutManager=tableRVLayoutManager
        tableRV.setHasFixedSize(true)
        Log.d("확인 MenuFragment.bind", "3")

    }
}