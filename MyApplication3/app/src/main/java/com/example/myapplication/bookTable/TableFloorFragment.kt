package com.example.myapplication.bookTable

import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Color.parseColor
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
import kotlin.math.round

//tableVPAdapter에서 사용
//테이블 레이아웃 부분 바인드
class TableFloorFragment():Fragment()  {
    //NoticeDialogFragment.NoticeDialogListener
    //lateinit var bookData:BookData
    var pos:Int = 0
    var tfFragment = this
    var tableButtonAR = ArrayList<Button>()

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


        //빨강 CC5555
        //초록 55CC55
        //회색 CCCCCC

        var i = 0



        i=0//테이블 통합
        while(i<tableData.tableList.size){
            var count = i
            var button= Button(getContext())


            //val roundDrawable = resources.getDrawable(R.drawable.button_round, null)
            //button.background = roundDrawable
            if (tableData.tableList[count].isCircle==true)//원형테이블
            {
                var roundDrawable= resources.getDrawable(R.drawable.button_round_gray, null)
                if (tableData.tableList[count].isBooked == true){//예약이 돼있으면
                    roundDrawable = resources.getDrawable(R.drawable.button_round_red, null)
                    button.setOnClickListener {
                        val myToast = Toast.makeText(context, "테이블이 이미 예약되어있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                else{//예약 안되어있으면
                    roundDrawable = resources.getDrawable(R.drawable.button_round_gray, null)
                    button.setOnClickListener {
                        //Log.d("확인 원형테이블 인원", tableData.circleTableList[i].maxP.toString())
                        showDialog(tableData.tableList[count].maxP)
                    }
                }
                button.background = roundDrawable
            }
            else{//사각 테이블
                if (tableData.tableList[count].isBooked == true){//이미 예약 된 경우
                    button.setBackgroundColor(parseColor("#CC5555"))
                    button.setOnClickListener {
                        val myToast = Toast.makeText(context, "테이블이 이미 예약되어있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                else{//dialogFragment 검색 or kotlin popup
                    button.setBackgroundColor(parseColor("#CCCCCC"))
                    button.setOnClickListener {

                        showDialog(tableData.tableList[count].maxP)

                    }
                }


            }



            var layoutParams = ConstraintLayout.LayoutParams (dpToPx(tableData.tableList[i].lengX), dpToPx(tableData.tableList[i].lengY))
            //with와 height에 픽셀값 들어감 => dp를 픽셀값으로 변환한 값 들어가야 한다.

            layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.horizontalBias =tableData.tableList[count].locX//0.5가 중앙
            layoutParams.verticalBias =tableData.tableList[count].locy

            button.setLayoutParams(layoutParams)
            tableLayout.addView(button)

            tableButtonAR.add(button)
            i++
        }




    }

    public fun dpToPx(dp:Int):Int {
        var density:Float = getResources().getDisplayMetrics().density;
        return Math.round(dp.toFloat() * density.toFloat()).toInt()
    }

    public fun showDialog(tablePerson:Int){
        var customDialog = BookPersonDialog(this!!.getContext()!!, tablePerson, tfFragment)
        customDialog!!.show()
    }
    //dialog에서 인원수 선택 버튼 클릭될 경우
    public fun pNumButtonClicked(tableNum:Int, pnum:Int){
        Log.d("확인 TableFloorFragment()", "dialog 예약 확인"+tableNum.toString()+" "+tableButtonAR.size.toString())
        tableButtonAR[tableNum].setBackgroundColor(parseColor("#CC5555"))
        tableButtonAR[tableNum].setText(pnum.toString())
    }
    public fun cancelButtonClicked(tableNum:Int){

    }



}