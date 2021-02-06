package com.example.myapplication.bookTable

//이것도 DB접속해서 가져와야하나?

class TableData(val sikdangId:Int, val bookTime:String) {
    //가로좌표 세로좌표 가로길이 세로길이
    //var recTable=arrayListOf(0, 0, 0, 0)
    //var circleTable=arrayListOf(0, 0, 0, 0)

    var recTableList=ArrayList<RecTable>()
    var circleTableList=ArrayList<CircleTable>()


    init{
        setData()

    }
    //여기서 DB 접근 현재는 임시데이터
    private fun setData(){
        var recNum = 3
        var cirNum = 2

        recTableList.add(RecTable(0.5F, 0.5F, 0.05F, 0.05F, 4, false))
        recTableList.add(RecTable(0.7F, 0.5F, 0.05F, 0.05F, 4, true))
        recTableList.add(RecTable(0.9F, 0.5F, 0.05F, 0.05F, 4, false))
        circleTableList.add(CircleTable(0.5F, 0.7F, 0.05F, 0.05F, 4, false))
        circleTableList.add(CircleTable(0.5F, 0.9F, 0.05F, 0.05F, 4, true))

    }

    inner class RecTable(var locX:Float, var locy:Float, var lengX:Float, var lengY:Float, var maxP:Int, var isBooked:Boolean){
    }
    inner class CircleTable(var locX:Float, var locy:Float, var lengX:Float, var lengY:Float, var maxP:Int, var isBooked:Boolean){
    }
}