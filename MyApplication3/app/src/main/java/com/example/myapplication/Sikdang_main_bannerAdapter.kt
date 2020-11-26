package com.example.myapplication

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView




class Sikdang_main_bannerAdapter(var context: Context, var bannerList: ArrayList<Sikdang_main_banner>) : RecyclerView.Adapter<Sikdang_main_bannerAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Sikdang_main_bannerAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.sikdang_main_banner, parent, false)
        //val view: View = inflater.inflate(R.layout.sikdang_main_banner, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(bannerList[position], context)
    }




    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var banner_insert= itemView?.findViewById<Button>(R.id.banner_button);
        fun bind(item: Sikdang_main_banner, context: Context) {

            /*
            var i: Int = 0;
            var n: Int = 4;
            while (i < n) {
                var banner_insert = itemView?.findViewById<Button>(R.id.banner_button);
                banner_insert?.setBackgroundResource(bannerList[i].banner1)
                i++
            }*/


            banner_insert?.setBackgroundResource(item.banner1)


        }
    }
}