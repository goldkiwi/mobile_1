package com.example.myapplication.sikdangChoicePage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

//프래그먼트내의 리사이클러뷰에 메뉴라인 바인드하는 어댑터 클래스
class SikdangChoiceMenuAdapter(var context : Context, val sikdangMenuData: SikdangMenuData):RecyclerView.Adapter<SikdangChoiceMenuAdapter.Holder>() {


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
            var sikdangImage :ImageView = itemView.findViewById(R.id.sikdangImage)
            sikdangImage.setBackgroundResource(sikdangMenuData.getSikdangImage())

            var sikdangNameTV : TextView = itemView.findViewById(R.id.sikdangName)
            sikdangNameTV.setText(sikdangMenuData.getSikdangName())

            var repMenuTV1 : TextView = itemView.findViewById(R.id.repMenuTV1)
            var repMenuTV2 : TextView = itemView.findViewById(R.id.repMenuTV2)
            var repMenuTV3 : TextView = itemView.findViewById(R.id.repMenuTV3)
            var repMenuTV4 : TextView = itemView.findViewById(R.id.repMenuTV4)

            repMenuTV1.setText(sikdangMenuData.getrepMenuArrayList()[0])
            repMenuTV2.setText(sikdangMenuData.getrepMenuArrayList()[1])
            repMenuTV3.setText(sikdangMenuData.getrepMenuArrayList()[2])
            repMenuTV4.setText(sikdangMenuData.getrepMenuArrayList()[3])

            if (sikdangMenuData.getanyList()[0] == 0){

            }

        }


    }
}