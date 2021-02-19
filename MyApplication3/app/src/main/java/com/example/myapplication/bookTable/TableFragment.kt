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
//v페이지 돌아왔을 때 정보 저장하려면 액티비티로 정보를 보내야할듯
class TableFragment: Fragment() {
    lateinit var bookData:BookData
    lateinit var tableData:TableData

    var isBack =false
    var backAL =ArrayList<ArrayList<Int>>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 TableFragment", "onCreateView")
        var view = inflater.inflate(R.layout.booktable_fragment, container, false)


        bind(view)
        return view
    }



    init{

    }
    //뷰페이저에 어댑터 연결
    public fun bind(view:View){
        Log.d("확인 TableFragment", "bind")
        var bundle = getArguments()
        if (bundle != null) bookData = bundle.getSerializable("bookData") as BookData
        else{
            Log.d("확인 TimeFragment.bind", "else")
        }
        tableData= TableData(bookData.getSikdangId(), bookData.getBookTime())

        if (isBack == true){//백 버튼으로 돌아오는 경우 수행

            tableData.setTableBookAL(backAL)
            tableData.isBack = true
            isBack = false
            //Log.d("확인 bookData에 어레이리스트 backAL 넣음", "이 값이 변동되는지 확인해야 함")
            //tableData.logTableBookArrayList()
            //여기서 넣는 값에는 문제 없었음
        }
        else{
            var tempALAL = ArrayList<ArrayList<Int>>()
            var i = 0
            var pageNum = 0
            var floorNum = tableData.tableList[0].floor
            /*
            while (i < tableData.tableList.size){
                if (floorNum < tableData.tableList[i].floor){
                    pageNum ++
                    floorNum < tableData.tableList[i].floor
                }
                tempALAL[pageNum].add(0)
                i++
            }*/
            var tempAL = ArrayList<Int>()
            while (i<tableData.tableList.size) {

                if (floorNum < tableData.tableList[i].floor){
                    pageNum ++
                    tempALAL.add(tempAL)
                    tempAL = ArrayList<Int>()
                    floorNum = tableData.tableList[i].floor
                }
                tempAL.add(0)
                i++

            }


            tableData.logTableBookArrayList()
        }
        //뷰페이저
        var vp = view.findViewById<ViewPager2>(R.id.tableVP)
        var vpAdapter = TableVPAdapter(this.getActivity()!!, bookData, tableData)
        vp.adapter=vpAdapter
        var bookTimeActivity= activity as BookTime
        bookTimeActivity.tableInfoInit(tableData.floorList.size, tableData.tableNumList)//BookTime 에서 초기 테이블 정보 초기화
        bookTimeActivity.setTableData_(tableData)
        var completeButton = view.findViewById<Button>(R.id.tableCompleteButton)
        completeButton.setOnClickListener {
            Log.d("확인 TableFragment", "BookTime의 bookTimeActivity호출")
            bookTimeActivity.replaceMenuFragment()
        }

    }


    public fun setTableNumAL(tableNumAL:ArrayList<ArrayList<Int>>){
        Log.d("확인 TableFragment", "setTableNumAL 수행")



        var i = 0
        var tempString = ""
        while (i < tableNumAL.size) {
            var j = 0
            while (j < tableNumAL[i].size) {
                //tableNumARString[k] = tableNumAR[i][j]
                tempString+= tableNumAL[i][j].toString()
                j++
            }
            tempString+="n"
            i++
        }
        Log.d("확인 TableFragment.setTableNumAL 문자열 변환 확인", tempString)

        //tableData.setTableBookAL(tableNumAL)
        backAL = tableNumAL
        isBack = true
    }

    public fun logtableDataAL(){
        var tempString = ""
        var i = 0
        while (i < tableData.tableBookArrayList.size) {
            var j = 0
            while (j < tableData.tableBookArrayList[i].size) {
                //tableNumARString[k] = tableNumAR[i][j]
                tempString+= tableData.tableBookArrayList[i][j].toString()
                j++
            }
            tempString+="n"
            i++
        }
        Log.d("확인 TableFragment 테이블데이터에 따라온 데이터 확인", tempString)
    }







}