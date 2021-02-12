package com.example.myapplication.bookMenu

import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTable.BookPersonDialog
import com.example.myapplication.bookTable.PersonNumRVAdapter

class MenuTableRVAdapter(var context: Context, menuData:MenuData) : RecyclerView.Adapter<MenuTableRVAdapter.Holder>()  {
    var a = 1




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.bookmenu_eachtable, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {//리사이클러뷰에 몇개 들어갈것인가
        return 1
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(pos:Int){
            var tableNumTV:TextView = itemView.findViewById(R.id.tableNumTV)
            tableNumTV.setText("테이블"+pos.toString())


            var tableRV : RecyclerView = itemView.findViewById(R.id.tableRV)
            var innerRVAdapter = InnerRVAdapter(context)
            tableRV.adapter = innerRVAdapter

            var RVLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            tableRV.layoutManager=RVLayoutManager
            tableRV.setHasFixedSize(true)

        }


        //리사이클러뷰 내부의 리사이클러뷰 어댑터

        inner class InnerRVAdapter(var context: Context): RecyclerView.Adapter<InnerRVAdapter.InnerHolder>(){



            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerRVAdapter.InnerHolder {
                val innerView = LayoutInflater.from(context).inflate(R.layout.bookmenu_eachtable, parent, false)
                return InnerHolder(innerView)
            }

            //여기에는 각 테이블에 예약된 메뉴 몇종류인가가 들어가야 함
            //미리 상위에서 받아오는게 좋을듯 함
            override fun getItemCount(): Int {
                return 1
            }

            override fun onBindViewHolder(holder: InnerHolder, position: Int) {
                holder.innerBind(position)
            }

            inner class InnerHolder(innerView:View):RecyclerView.ViewHolder(innerView){
                public fun innerBind(pos:Int){

                }

            }

        }

    }
}