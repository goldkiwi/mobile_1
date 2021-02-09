package com.example.myapplication.bookTable

//이것도 DB접속해서 가져와야하나?

class TableData(val sikdangId:Int, val bookTime:String) {
    //가로좌표 세로좌표 가로길이 세로길이

    var tableList = ArrayList<Table>()


    init{
        setData()

    }
    //여기서 DB 접근 현재는 임시데이터
    //tableList 만 채워주면 된다
    private fun setData(){

        tableList.add(Table(0.5F, 0.3F, 30, 30, 2, true, true))
        tableList.add(Table(0.6F, 0.3F, 30, 30, 2, false, true))
        tableList.add(Table(0.7F, 0.3F, 30, 30, 4, false, true))
        tableList.add(Table(0.2F, 0.6F, 60, 30, 6, false, false))
        tableList.add(Table(0.35F, 0.6F, 60, 30, 3, true, false))

    }

    inner class Table(var locX:Float, var locy:Float, var lengX:Int, var lengY:Int, var maxP:Int, var isBooked:Boolean, var isCircle:Boolean){
    }

}