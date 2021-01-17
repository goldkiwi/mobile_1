package com.example.myapplication.recommendation

import android.os.Parcel
import android.os.Parcelable
import android.util.Log

//Parcelable 넣음으로서 putExtra로 넘겨줄 수 있게 한다
class MsgCat(): Parcelable {
    val tagListMax = 18 //리스트 개수 = 태그 개수
    var orderMax = 0//우선순위 붙은 태그 갯수 = 최대우선순위

    //private var catName="먹을거"
    //var tagOrderList = Array(tagListMax, { 0 })
    //var tagOrderList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    var tagOrderList : ArrayList<Int> = arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val tagList = arrayOf("소고기", "닭고기", "돼지고기", "매운맛", "달콤한맛", "구수한맛", "짠맛", "뜨거운것", "시원한것", "생선", "새우", "조개", "소주", "맥주", "막걸리", "데이트", "단체", "혼밥")
    var orderText = "aaaaaa"


    constructor(parcel: Parcel) : this() {
        orderMax = parcel.readInt()
        orderText = parcel.readString().toString()
        Log.d("확인 MsgCat constructor 복사 확인", orderText)
        logOrderList()
        parcel.readArrayList(Int::class.java.classLoader) as ArrayList<Int>
        //parcel.readList(tagOrderList, Int.javaClass.classLoader)
        //tagOrderList= parcel.readArray(Int.javaClass.classLoader) as Array<Int>
        //tagOrderList=parcel.readArray(Int::class.java)
        logOrderList()
        Log.d("확인 MsgCat constructor 복사 확인2", orderText)
        logOrderList()
        Log.d("확인 MsgCat constructor", "종료 확인")
    }

    public fun setListOn(catName: String) {
        Log.d("확인 MsgCat setListOn", catName)
        for (i in 0 until tagListMax) {//태그 리스트 한바퀴 돔
            if (catName == tagList[i]) if (tagOrderList[i] == 0) tagOrderList[i] = ++orderMax//catName을 태그리스트중에 찾고 그 태그가 몇번째인지 알게됐으니 그걸로 우선순위 확인하고 올림
        }
        logOrderList()
    }

    public fun setListOff(catName: String) {
        Log.d("확인 MsgCat setListOff", catName)
        var catNum = 0
        for (i in 0 until tagListMax) if (catName == tagList[i]) catNum = i //catNum은 태그가 리스트의 몇 번째인지
        var catOrderNum = tagOrderList[catNum] //catOrderNum 은 우선순위 몇 번쨰인지
        listDown(catOrderNum)
        tagOrderList[catNum] = 0
        logOrderList()
    }

    private fun setText() {
        var listString: String = ""
        for (i in 0 until tagListMax) {
            var listChar = tagOrderList[i].toString()
            listString += tagList[i]
            listString += listChar
        }
        orderText = listString
    }

    public fun getText(): String {
        setText()
        Log.d("확인 MsgCat getText : orderText, 아래는 logOrderList", orderText)
        logOrderList()

        return orderText
    }

    public fun logOrderList() {
        var listString: String = "orderMax = "
        listString += orderMax.toString()

        for (i in 0 until tagListMax) {
            var listChar = tagOrderList[i].toString()
            listString += tagList[i]
            listString += listChar
        }
        Log.d("확인 MsgCat logOrderList : List", listString)
    }


    private fun listDown(num: Int) {//받은 숫자보다 큰 숫자들은 모두 1씩 줄임

        if (orderMax == 0) return //우선순위 붙은 태그가 0개면 함수 종료
        for (i in 0 until tagListMax) if (tagOrderList[i] > num) tagOrderList[i]--
        orderMax--
    }

    public fun setList(catName: String) {
        when (catName) {
            "소고기" -> {
                if (tagOrderList[0] == 0) {
                    tagOrderList[0] = 1
                }
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(orderMax)
        parcel.writeString(orderText)
        //parcel.writeArray(tagOrderList)
        //parcel.writeList(tagOrderList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MsgCat> {
        override fun createFromParcel(parcel: Parcel): MsgCat {
            return MsgCat(parcel)
        }

        override fun newArray(size: Int): Array<MsgCat?> {
            return arrayOfNulls(size)
        }
    }
}

