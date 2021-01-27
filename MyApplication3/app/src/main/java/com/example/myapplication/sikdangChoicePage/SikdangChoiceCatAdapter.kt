package com.example.myapplication.sikdangChoicePage

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class SikdangChoiceCatAdapter(var context : Context, val catArrayList: ArrayList<String>?, var sikdangChoice_toggleButton_arrayList: ArrayList<ToggleButton>) : RecyclerView.Adapter<SikdangChoiceCatAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("종료지점확인 SikdangChoiceCatAdapter", "onCreateViewHolder 시작")
        val view = LayoutInflater.from(context).inflate(R.layout.sikdangchoice_cat, parent, false)
        Log.d("종료지점확인 SikdangChoiceCatAdapter", "onCreateViewHolder 2")
        return Holder(view)
    }

    override fun getItemCount(): Int {
        Log.d("종료지점확인 SikdangChoiceCatAdapter", "getItempCount()")
        return catArrayList?.size!!
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("종료지점확인 SikdangChoiceCatAdapter", "onBindViewHolder")
        holder.bind()
    }


    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        fun bind(){
            Log.d("종료지점확인 SikdangChoiceCatAdapter", "holder.bind()0")
            var sikdangChoice_toggleButton : ToggleButton = itemView.findViewById(R.id.sikdangchice_toggleButton)
            var catName: String? = catArrayList?.get(position)
            sikdangChoice_toggleButton.text=catName
            sikdangChoice_toggleButton.textOn=catName
            sikdangChoice_toggleButton.textOff=catName
            sikdangChoice_toggleButton_arrayList.add(sikdangChoice_toggleButton)


            sikdangChoice_toggleButton.setOnCheckedChangeListener{ _, isChecked ->
                if (isChecked){

                }else{

                }

            }
        }

    }
}