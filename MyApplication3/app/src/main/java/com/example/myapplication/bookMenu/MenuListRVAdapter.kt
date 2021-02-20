package com.example.myapplication.bookMenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MenuListRVAdapter(var context: Context, val menuData:MenuData):RecyclerView.Adapter<MenuListRVAdapter.Holder>()  {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.bookmenu_menubar, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return menuData.menus.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }


    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(pos:Int){
            var menuImage: ImageView = itemView.findViewById(R.id.menuImage)
            menuImage.setBackgroundResource(menuData.menus[pos].menuImage)
            var menuNameTV:TextView = itemView.findViewById(R.id.menuNameTV)
            menuNameTV.setText(menuData.menus[pos].name)
            var menuExpTV:TextView = itemView.findViewById(R.id.menuExpTV)
            menuExpTV.setText(menuData.menus[pos].menuExp)
            var menuPriceTV:TextView = itemView.findViewById(R.id.menuPriceTV)
            menuPriceTV.setText(menuData.menus[pos].price.toString()+"원")

            itemView.setOnClickListener {
                //메뉴 하나 클릭 됐을 때 수행
            }



        }

    }
}