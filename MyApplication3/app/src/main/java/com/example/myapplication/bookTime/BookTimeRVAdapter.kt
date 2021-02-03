package com.example.myapplication.bookTime

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BookTimeRVAdapter(var context: Context, val bookTimeData: BookTimeData):RecyclerView.Adapter<BookTimeRVAdapter.Holder>() {
    var timeNumMax = bookTimeData.getTimeArrayList().size
    var sikdangName = bookTimeData.getSikdangName()


    private fun timeset(){
        val current = LocalDateTime.now()
        val timeFormatter = DateTimeFormatter.ISO_TIME
        val currentTime = current.format(timeFormatter)
        var timeString:String=""
        timeString=timeString+currentTime[0]+currentTime[1]+currentTime[3]+currentTime[4]


        Log.d("확인 time ", "종료되나?")
        var i = 0
        while (i<bookTimeData.getTimeArrayList().size){
            if(timeString < bookTimeData.getTimeArrayList()[i]){
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

    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.booktime_timeline, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }


    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(){
            timeset()

        }
    }

}