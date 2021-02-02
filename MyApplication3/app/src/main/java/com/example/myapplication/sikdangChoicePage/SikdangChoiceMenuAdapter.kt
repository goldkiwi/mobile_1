package com.example.myapplication.sikdangChoicePage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

//프래그먼트내의 리사이클러뷰에 메뉴라인 바인드하는 어댑터 클래스
class SikdangChoiceMenuAdapter(var context : Context, val sikdangName:String):RecyclerView.Adapter<SikdangChoiceMenuAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.sikdangchoice_menuline, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }



    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!){

        fun bind(){
            var sikdangNameTV : TextView = itemView.findViewById(R.id.sikdangName)
            sikdangNameTV.setText(sikdangName)

        }


    }
}