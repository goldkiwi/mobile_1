package com.example.myapplication.bookTime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class BookTimeRVAdapter(var context: Context, bookTimeData: BookTimeData):RecyclerView.Adapter<BookTimeRVAdapter.Holder>() {
    var timeNumMax = bookTimeData.getTimeArrayList().size
    var sikdangName = bookTimeData.getSikdangName()



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

        }
    }

}