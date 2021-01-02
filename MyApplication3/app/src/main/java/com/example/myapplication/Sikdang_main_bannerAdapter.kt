package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView




class Sikdang_main_bannerAdapter(var context: Context, var bannerList: ArrayList<Sikdang_main_banner>) : RecyclerView.Adapter<Sikdang_main_bannerAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Sikdang_main_bannerAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.sikdang_main_banner, parent, false)
        //val view: View = inflater.inflate(R.layout.sikdang_main_banner, parent, false)
        Log.d("종료지점확인 Sikdang_main_bannerAdapter", "24")

        return Holder(view)
    }

    override fun getItemCount(): Int {
        Log.d("종료지점확인 Sikdang_main_bannerAdapter", "30")
        return bannerList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("종료지점확인 Sikdang_main_bannerAdapter", "35")
        holder.bind(bannerList[position], context)
    }

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null
    override fun onBindViewHolder(holder: Holder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        Log.d("종료지점확인 Sikdang_main_bannerAdapter", "46")

        if (itemClick != null){
            Log.d("종료지점확인 Sikdang_main_bannerAdapter", "49")
            holder?.itemView?.setOnClickListener{ v ->
                itemClick?.onClick(v, position)
            }
            Log.d("종료지점확인 Sikdang_main_bannerAdapter", "53")
        }
        Log.d("종료지점확인 Sikdang_main_bannerAdapter", "55")
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


            Log.d("종료지점확인 Sikdang_main_bannerAdapter", "72")
            banner_insert?.setBackgroundResource(item.banner1)
            Log.d("종료지점확인 Sikdang_main_bannerAdapter", "74")




        }
        /*
        fun banner_clicked(){

            val whatEatToday_page=Intent(Sikdang_main, What_eat_today::class.java)
            startActivity(whatEatToday_page)

        }*/

    }


}
