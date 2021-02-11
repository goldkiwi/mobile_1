package com.example.myapplication.bookMenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTable.BookPersonDialog
import com.example.myapplication.bookTable.PersonNumRVAdapter

class MenuTableRVAdapter(var context: Context) : RecyclerView.Adapter<MenuTableRVAdapter.Holder>()  {
    var a = 1




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.generalitem_button, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){

        public fun bind(pos:Int){

        }

    }
}