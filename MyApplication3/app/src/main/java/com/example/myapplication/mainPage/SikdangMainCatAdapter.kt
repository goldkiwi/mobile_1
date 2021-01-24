package com.example.myapplication.mainPage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class SikdangMainCatAdapter(var context: Context, val catList: ArrayList<String>) : RecyclerView.Adapter<SikdangMainCatAdapter.Holder>() {
    var a : String = "aaa"
    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int):SikdangMainCatAdapter.Holder{
        val view = LayoutInflater.from(context).inflate(R.layout.cat_line, parent, false)
        return Holder(view)
    }



    override fun getItemCount(): Int {
        return (catList.size)/2
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(catList[(position)*2],catList[(position)*2+1], context)
    }

    override fun onBindViewHolder(holder: Holder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        fun bind(item1:String, item2:String, context:Context){
            var catButtonUp : Button = itemView.findViewById(R.id.cat_button_up)
            var catButtonDown : Button = itemView.findViewById(R.id.cat_button_down)

            catButtonUp.setText(item1)
            catButtonDown.setText(item2)

        }

    }


}


