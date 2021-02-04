package com.example.myapplication.bookTime

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.sikdangChoicePage.SikdangChoiceMenuAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BookTimeFragment(val bookTimeData: BookTimeData) : Fragment() {
    /*
    var timeNumMax = bookTimeData.getTimeArrayList().size
    var timePoint = timeset()
    var vartimePoint=timePoint
    var sikdangName = bookTimeData.getSikdangName()*/



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.booktime_fragment, container, false)
        bind(view)
        return view
    }




/*

    private fun timeset():Int{
        val current = LocalDateTime.now()
        val timeFormatter = DateTimeFormatter.ISO_TIME
        val currentTime = current.format(timeFormatter)
        var timeString:String=""
        timeString=timeString+currentTime[0]+currentTime[1]+currentTime[3]+currentTime[4]


        //예약은 최소 30분 전에 해야함
        //코드는 나중에 추가하도록
        Log.d("확인 time ", "종료되나?")
        var i = 0
        while (i<bookTimeData.getTimeArrayList().size){
            if(timeString <= bookTimeData.getTimeArrayList()[i]){
                break
            }
            Log.d("확인 time 현재 다음 ", timeString+" "+bookTimeData.getTimeArrayList()[i])
            i++
        }
        if(i==bookTimeData.getTimeArrayList().size){
            //이경우는 하루 영업이 끝남
            Log.d("확인 time 현재 다음 ", timeString+"영업끝")
        }
        //Log.d("확인 time 현재 다음 ", timeString+" "+bookTimeData.getTimeArrayList()[i])


        //Log.d("확인 time", timeString+" "+bookTimeData.getTimeArrayList()[0])

        return i

    }
*/


    public fun bind(itemView:View){
        var bookTimeRV : RecyclerView = itemView.findViewById(R.id.bookTimeRV2)
        var bookTimeRVAdapter = BookTimeRVAdapter(this!!.getActivity()!!, bookTimeData)
        bookTimeRV.adapter = bookTimeRVAdapter


        var sikdangChice_catLineLM = LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)
        bookTimeRV.layoutManager=sikdangChice_catLineLM
        bookTimeRV.setHasFixedSize(true)




        /*

        //왼쪽버튼 바인드
        var buttonLeft: Button = itemView.findViewById(R.id.timeButtonLeft)
        buttonLeft.setText(bookTimeData.getTimeArrayList()[vartimePoint])
        if (bookTimeData.getIsFull()[vartimePoint]==false){//이시간대 예약이 꽉찬 경우
            buttonLeft.setBackgroundColor(Color.RED)
            buttonLeft.setOnClickListener {
            }
        }
        else{//예약이 빈 경우

        }

        //오른쪽 버튼 바인드
        var buttonRight: Button = itemView.findViewById(R.id.timeButtonRight)
        vartimePoint+=1
        if (vartimePoint<timeNumMax){
            buttonRight.setText(bookTimeData.getTimeArrayList()[vartimePoint])
            if (bookTimeData.getIsFull()[vartimePoint]==false){//예약이 가득 찬 경우
                buttonRight.setBackgroundColor(Color.RED)
            }
            else{//예약이 빈 경우

            }
            vartimePoint+=1
        }
        else{
            buttonRight.setText("")
        }*/



    }







}