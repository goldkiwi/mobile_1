package com.example.myapplication.bookTime

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//아예 그날 영업이 끝난 경우도 따로 상정해야할것

class BookTimeRVAdapter(var context: Context, val bookTimeData: BookTimeData):RecyclerView.Adapter<BookTimeRVAdapter.Holder>() {
    var timeNumMax = bookTimeData.getTimeArrayList().size
    var timePoint = timeset()
    var vartimePoint=timePoint
    var sikdangName = bookTimeData.getSikdangName()



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






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.booktime_timeline, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        var i =timeNumMax - timePoint
        Log.d("확인 getItemCount ", i.toString()+" "+(i/2).toString())
        return (i+1)/2
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    
    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(){

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
            }



        }
    }

}