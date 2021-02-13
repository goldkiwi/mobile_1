package com.example.myapplication.bookMenu

import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log
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
        Log.d("확인 MenuTableRVAdapter", "생성")
        val view = LayoutInflater.from(context).inflate(R.layout.bookmenu_eachtable, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {//리사이클러뷰에 몇개 들어갈것인가
        return 2
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(pos:Int){
            Log.d("확인 MenuTableRVAdapter", "Holder.bind")
            //테이블 번호
            var tableNumTV:TextView = itemView.findViewById(R.id.tableNumTV)
            tableNumTV.setText("테이블"+pos.toString())
            Log.d("확인 MenuTableRVAdapter", "Holder.bind2")

            var tableMenuRV : RecyclerView = itemView.findViewById(R.id.tableMenuRV)
            Log.d("확인 MenuTableRVAdapter", "Holder.bind2.1")
            var innerRVAdapter = InnerRVAdapter(context)
            Log.d("확인 MenuTableRVAdapter", "Holder.bind2.2")
            tableMenuRV.adapter = innerRVAdapter
            Log.d("확인 MenuTableRVAdapter", "Holder.bind3")

            var RVLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            tableMenuRV.layoutManager=RVLayoutManager
            tableMenuRV.setHasFixedSize(true)

        }


        //리사이클러뷰 내부의 리사이클러뷰 어댑터

        inner class InnerRVAdapter(var innerContext: Context): RecyclerView.Adapter<InnerRVAdapter.InnerHolder>(){



            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerRVAdapter.InnerHolder {
                Log.d("확인 MenuTableRVAdapter.innerRVAdapter", "생성")
                //여기서 레이아웃은 메뉴 한줄이 들어가야 함
                val innerView = LayoutInflater.from(innerContext).inflate(R.layout.generalitem_button, parent, false)
                return InnerHolder(innerView)
            }

            //여기에는 각 테이블에 예약된 메뉴 몇종류인가가 들어가야 함
            //미리 상위에서 받아오는게 좋을듯 함
            override fun getItemCount(): Int {
                return 3
            }

            override fun onBindViewHolder(holder: InnerHolder, position: Int) {
                holder.innerBind(position)
            }

            inner class InnerHolder(innerView:View):RecyclerView.ViewHolder(innerView){
                public fun innerBind(pos:Int){
                    Log.d("확인 MenuTableRVAdapter.innerRVAdapter  innerBind", "생성")

                }

            }

        }

    }
}