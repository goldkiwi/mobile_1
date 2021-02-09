package com.example.myapplication.bookTable

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class PersonNumRVAdapter(var context: Context, val maxP:Int, val bookPersonDialog: BookPersonDialog):RecyclerView.Adapter<PersonNumRVAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.generalitem_button, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return maxP
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }


    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(pos:Int){
            var count = pos
            var button = itemView.findViewById<Button>(R.id.gItem_button)
            //button.width = 5
            button.setText((pos+1).toString())
            var pNum = pos+1
            button.setOnClickListener {
                //버튼 클릭하면 이전 액티비티로 데이터 전달
                button.setBackgroundColor(Color.parseColor("#55CC55"))
                bookPersonDialog.buttonClicked(pNum)
            }

        }


    }
}