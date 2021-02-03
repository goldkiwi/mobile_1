package com.example.myapplication.sikdangChoicePage

import android.util.Log
import com.example.myapplication.R

class SikdangMenuData() {
    private var sikdangId : Int = 0
    private var sikdangImage : Int = R.drawable.foodimage //식당의 이미지
    private var sikdangName : String = "식당이름"
    private var dist : Float = 0.toFloat()
    private var repMenuArrayList:ArrayList<String> = arrayListOf("대표메뉴1", "대표메뉴2", "대표메뉴3", "대표메뉴4")
    private var anyList:ArrayList<Int> = arrayListOf(0, 0, 0)//순서대로 주차여부 쿠폰 미정
    //주차여부 0이면 주차 불가능 1이면 무료주차 1이면 유료주차
    //쿠폰 0이면 없음 1이면 있음
    private var pos = 0
    //lateinit private var reqData




    //카테고리 메뉴의 몇번째 위치인지, 현재 위치 주면
    //식당의 id, 식당 이미지, 이름, 대표메뉴, 기타 리스트, 거리 채워준다
    /*
    constructor(cat:String, pos:Int, coorX : Float, coorY:Float):this(){
        setData(cat, this.pos, coorX, coorY)
    }
    constructor(cat:String, coorX : Float, coorY:Float):this(){
        setData(cat, coorX, coorY)
    }*/
    constructor(reqData: SikdangListReqData):this()
    {
        setData(reqData.getCat(), reqData.getPos(), reqData.getCoorX(), reqData.getCoorY(), reqData.getMaxDist())
    }


    public fun getSikdangId():Int{
        return sikdangId
    }
    public fun getSikdangImage() : Int{
        return sikdangImage
    }
    public fun getSikdangName():String{
        return sikdangName
    }
    public  fun getSikdangDist():Float{
        return dist
    }
    public fun getrepMenuArrayList():ArrayList<String>{
        return repMenuArrayList
    }
    public fun getanyList():ArrayList<Int>{
        return anyList
    }

    public fun setPos(pos:Int){

    }



    //데이터베이스에서 가저와서 각 변수에 넣어야 함
    private fun setData(cat:String, pos:Int, coorX : Float, coorY:Float, dist_:Int){
        sikdangId = 12345678
        sikdangImage = R.drawable.foodimage //식당의 이미지
        sikdangName = cat+" "+pos.toString() // 식당 이름
        //Log.d("확인 SikdangMenuData", "setData")
        dist = dist_.toFloat()
        repMenuArrayList = arrayListOf("대표메뉴1", "대표메뉴2", "대표메뉴3", "대표메뉴4") // 대표메뉴 네개
        anyList= arrayListOf(0, 0, 0)
    }
    /*
    fun setData(cat:String, coorX : Float, coorY:Float){
        sikdangId = 12345678
        sikdangImage = R.drawable.foodimage //식당의 이미지
        sikdangName = cat+" "+pos.toString() // 식당 이름
        dist = 123.4567.toFloat()
        repMenuArrayList = arrayListOf("대표메뉴1", "대표메뉴2", "대표메뉴3", "대표메뉴4") // 대표메뉴 네개
        anyList= arrayListOf(0, 0, 0)
    }
*/
}

