package com.example.myapplication.payPage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.mainPage.SikdangMainCatAdapter

class CouponListRVAdapter(var context:Context): RecyclerView.Adapter<CouponListRVAdapter.Holder>() {







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.paypage_coupondialog_couponline, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //super.onBindViewHolder(holder, position)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        public fun bind(){

        }
    }
}