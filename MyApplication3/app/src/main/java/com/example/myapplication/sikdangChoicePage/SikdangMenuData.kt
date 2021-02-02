package com.example.myapplication.sikdangChoicePage

import com.example.myapplication.R

class SikdangMenuData() {
    private var sikdangImage : Int = R.drawable.foodimage //식당의 이미지
    private var sikdangName : String = "식당이름"
    private var repMenuArrayList:ArrayList<String> = arrayListOf("대표메뉴1", "대표메뉴2", "대표메뉴3", "대표메뉴4")
    private var anyList:ArrayList<Int> = arrayListOf(0, 0, 0, 0)

    constructor(cat:String, dist:Int, coorX : Float, coorY:Float) : this(){
        getData(cat, dist, coorX , coorY)
    }


    public fun getSikdangImage() : Int{
        return sikdangImage
    }
    public fun getSikdangName():String{
        return sikdangName
    }
    public fun getrepMenuArrayList():ArrayList<String>{
        return repMenuArrayList
    }
    public fun getanyList():ArrayList<Int>{
        return anyList
    }

    //데이터베이스에서 가저와서 각 변수에 넣어야 함
    private fun getData(cat:String, dist:Int, coorX : Float, coorY:Float){
        sikdangImage= R.drawable.foodimage //식당의 이미지
        sikdangName = cat
        repMenuArrayList = arrayListOf("대표메뉴1", "대표메뉴2", "대표메뉴3", "대표메뉴4")
        anyList= arrayListOf(0, 0, 0, 0)
    }

}

