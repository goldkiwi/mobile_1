package com.example.myapplication.recommendation

import android.util.Log

class MsgCat {
    val tagListMax=18 //리스트 개수 = 태그 개수
    var orderMax=0//우선순위 붙은 태그 갯수 = 최대우선순위
    //private var catName="먹을거"
    var tagOrderList = Array(tagListMax, {0})
    val tagList=arrayOf("소고기", "닭고기", "돼지고기", "매운맛", "달콤한맛", "구수한맛", "짠맛", "뜨거운것", "시원한것", "생선", "새우", "조개", "소주", "맥주", "막걸리", "데이트", "단체", "혼밥")
    var orderText=""

    public fun setListOn(catName: String){
        Log.d("확인 MsgCat setListOn", catName)
        for (i in 0 until tagListMax){//태그 리스트 한바퀴 돔
            if (catName==tagList[i]) if (tagOrderList[i]==0) tagOrderList[i]=++orderMax//catName을 태그리스트중에 찾고 그 태그가 몇번째인지 알게됐으니 그걸로 우선순위 확인하고 올림
        }
        logOrderList()
    }
    public fun setListOff(catName: String){
        Log.d("확인 MsgCat setListOff", catName)
        var catNum=0
        for (i in 0 until tagListMax) if (catName==tagList[i]) catNum=i //catNum은 태그가 리스트의 몇 번째인지
        var catOrderNum = tagOrderList[catNum] //catOrderNum 은 우선순위 몇 번쨰인지
        listDown(catOrderNum)
        tagOrderList[catNum]=0
        logOrderList()
    }
    private fun setText(){
        var listString :String=""
        for (i in 0 until tagListMax){
            var listChar = tagOrderList[i].toString()
            listString+=tagList[i]
            listString+=listChar
        }
        orderText=listString
    }

    public fun getText():String{
        return orderText
    }

    public fun logOrderList(){
        var listString :String=""
        for (i in 0 until tagListMax){
            var listChar = tagOrderList[i].toString()
            listString+=tagList[i]
            listString+=listChar
        }
        Log.d("확인 MsgCat setList : List", listString)
    }


    private fun listDown(num:Int){//받은 숫자보다 큰 숫자들은 모두 1씩 줄임
        if (orderMax==0) return //우선순위 붙은 태그가 0개면 함수 종료
        for (i in 0 until tagListMax) if (tagOrderList[i]>num) tagOrderList[i]--
        orderMax--
    }
    public fun setList(catName:String){
        when (catName){
            "소고기"->{
                if (tagOrderList[0]==0){
                    tagOrderList[0]=1
                }
            }
        }
    }
}