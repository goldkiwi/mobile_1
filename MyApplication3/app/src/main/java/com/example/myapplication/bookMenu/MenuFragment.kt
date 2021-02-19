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
import com.example.myapplication.bookTable.TableData
import com.example.myapplication.bookTime.BookData

class MenuFragment: Fragment() {
    lateinit var bookData:BookData
    lateinit var menuData:MenuData
    lateinit var tableData: TableData
    var tableNumAR=ArrayList<ArrayList<Int>>()
    var bookTableNum = 0
    //var tableNumString = ""//테이블

    init{

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 MenuFragment", "생성")
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater.inflate(R.layout.bookmenu_fragment, container, false)
        var bundle = getArguments()
        if (bundle != null) {
            bookData = bundle.getSerializable("bookData") as BookData
            menuData = bundle.getSerializable("menuData") as MenuData
            tableData = bundle.getSerializable("tableData") as TableData
            //Log.d("확인 MenuFragment", "2")
            //tableNumAR = (bundle.getParcelableArrayList("tabkeNumAR") as ArrayList<Int>?)!!
            //문제가 인트 리스트가 아니라 문자열로 넘어온다
            val tableNumList = bundle.getParcelableArrayList<Parcelable?>("tableNumAR")as ArrayList<Int>
            var tableNumString = bundle.getString("tableNumARString")
            //Log.d("확인 문자열로 넘어왔는지 확인", tableNumString.toString())
            var i = 0
            var j = 0
            var k = 0
            var tempString = tableNumString.toString()
            //Log.d("확인 MenuFragment 서브스트링 접근 확인", tempString)
            //Log.d("확인 MenuFragment 서브스트링 접근 확인", tempString.substring(5..5))

            //var tempString=""
            bookTableNum = 0
            while (i< tableNumList!!.size){
                //Log.d("확인 MenuFragment", tableNumList.size.toString()+" i 반복"+i.toString())
                //tempString+=tableNumList[i].toString()
                var tempNumAR:ArrayList<Int> =  ArrayList<Int>()
                while (tableNumString!!.substring(j..j) != "n"){
                    var tablePNum:Int = tableNumString!!.substring(j..j).toInt()
                    tempNumAR.add(tablePNum)
                    if (tablePNum != 0) bookTableNum ++
                    j++
                    //Log.d("확인 MenuFragment while (tableNumString!!.substring(j) != \"n\")", i.toString()+j.toString()+k.toString()+tableNumString!!.substring(j..j))
                }
                tableNumAR.add(tempNumAR)
                i++
                j++
                //Log.d("확인 MenuFragment while (tableNumString!!.substring(j) != \"n\")", "큰 와일문 끝")
            }

            //Log.d("확인 MenuFragment tableNumAR 넘어왔는지 확인", tempString)
        }
        else{
            Log.d("확인 MenuFragment bundle 받아오기", "else")
        }
        //Log.d("확인 MenuFragment", "2")


        bind(view)
        return view
    }
    fun bind(itemView:View){
        //Log.d("확인 MenuFragment.bind", "1")


        //각 테이블별로 어떤 메뉴가 예약 되었는지 표시해주는 리사이클러뷰
        var tableRV : RecyclerView = itemView.findViewById(R.id.tableRV)
        var menuTableRVAdapter = MenuTableRVAdapter(this!!.getActivity()!!, menuData, bookTableNum, tableNumAR, tableData.floorList)
        tableRV.adapter = menuTableRVAdapter
        //Log.d("확인 MenuFragment.bind", "2")

        var tableRVLayoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)
        tableRV.layoutManager=tableRVLayoutManager
        tableRV.setHasFixedSize(true)
        //Log.d("확인 MenuFragment.bind", "3")

    }
}