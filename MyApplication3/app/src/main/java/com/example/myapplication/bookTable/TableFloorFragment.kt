package com.example.myapplication.bookTable

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.bookTime.BookData

//tableVPAdapter에서 사용
//테이블 레이아웃 부분 바인드
class TableFloorFragment():Fragment() {
    //lateinit var bookData:BookData
    var pos:Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 TableFloorFragment()", "onCreateView")

        var view = inflater.inflate(R.layout.booktable_floorfragment, container, false)



        bind(view)
        return view
    }


    public fun bind(view:View){
        lateinit var bookData:BookData
        var bundle = getArguments()
        if (bundle != null) {
            bookData = bundle.getSerializable("bookData") as BookData
            pos = bundle.getInt("pos")
        }
        else{
            Log.d("확인 TimeFragment.bind", "else")
        }
        var floorText:TextView = view.findViewById(R.id.floorText)
        floorText.setText((pos+1).toString()+"층 "+bookData.getBookTime())

        var tableData= TableData(bookData.getSikdangId(), bookData.getBookTime())

        var tableLayout:ConstraintLayout = view.findViewById(R.id.floorLayout)

        //var layoutParam = RelativeLayout.LayoutParams (ViewGroup.LayoutParams. WRAP_CONTENT , ViewGroup.LayoutParams. WRAP_CONTENT )



        var i = 0
        Log.d("확인 TableFloorFragment().bind", tableData.recTableList.size.toString())
        while(i<tableData.recTableList.size){
            var button= Button(getContext())
            if (tableData.recTableList[i].isBooked == true){
                button.setBackgroundColor(Color.GRAY)
            }
            else{
                button.setBackgroundColor(Color.RED)
            }
            //button.width = tableData.recTableList[i].lengX.toInt()
            ///button.height = tableData.recTableList[i].lengY.toInt()
            ///button.width =5

            //var layoutParams = ConstraintLayout.LayoutParams (ViewGroup.LayoutParams. WRAP_CONTENT , ViewGroup.LayoutParams. WRAP_CONTENT )
            var layoutParams = ConstraintLayout.LayoutParams (dpToPx(50), dpToPx(50))
            //with와 height에 픽셀값 들어감 => dp를 픽셀값으로 변환한 값 들어가야 한다.

            layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.horizontalBias =tableData.recTableList[i].locX
            layoutParams.verticalBias =tableData.recTableList[i].locy



            button.setLayoutParams(layoutParams)
            tableLayout.addView(button)
            //layoutParam.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
            //layoutParam.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
            //var strImage = R.drawable.sikdangimage
            //var sikdangStr: ImageView = ImageView(getContext())
            //sikdangStr.setBackgroundResource(strImage)
            //sikdangStr.setLayoutParams(layoutParam)
            //button.setLayoutParams(layoutParam)
            //button.constra

            i++
        }


    }

    public fun dpToPx(dp:Int):Int {
        var density:Float = getResources().getDisplayMetrics().density;
        return Math.round(dp.toFloat() * density.toFloat()).toInt()
    }


}