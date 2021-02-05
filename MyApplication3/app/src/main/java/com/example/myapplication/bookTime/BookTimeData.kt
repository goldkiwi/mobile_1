package com.example.myapplication.bookTime

import com.example.myapplication.R

class BookTimeData(sikdangId_:Int) {
    private var sikdangName: String = ""
    private var sikdangImage:Int=0
    private val sikdangId = sikdangId_
    lateinit private var timeArrayList:ArrayList<String> //예약 시간을 arrayList로
    lateinit private var isFull:ArrayList<Boolean> // 각 예약시간대에 예약이 차있는가
    init{
        setData(sikdangId)
    }


    public fun getSikdangId():Int{
        return sikdangId
    }
    public fun getSikdangImage():Int{
        return sikdangImage
    }
    public fun getSikdangName():String{
        return sikdangName
    }
    public fun getTimeArrayList():ArrayList<String>{
        return timeArrayList
    }
    public fun getIsFull():ArrayList<Boolean>{
        return isFull
    }


    //여기세 데이터베이스 접속해서
    //지금 들어가있는건 임시 데이터
   private fun setData(sikdangId: Int){
        sikdangName = "시이이익당이름"
        sikdangImage= R.drawable.sikdangimage
        timeArrayList = arrayListOf("0930", "1000", "1030", "1100",
                "1130", "1200", "1230", "1300",
                "1330", "1400", "1430", "1500",
                "1530", "1600", "1630", "1700",
                "1730", "1800", "1830", "1900",
                "1930", "2000", "2030", "2100",
                "2130", "2200", "2230", "2300",
                "2330", "2400")
        isFull = arrayListOf(true, true, false, true,
                true, true, true, true,
                false, false, true, true,
                true, false, false, true,
                false, false, false, false,
                true, true, false, true,
                false, false, true, true,
                false, true)

    }


}