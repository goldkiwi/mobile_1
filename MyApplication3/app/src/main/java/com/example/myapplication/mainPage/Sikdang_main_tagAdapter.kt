package com.example.myapplication.mainPage

import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.View
import android.widget.ToggleButton
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recommendation.MsgCat
import java.security.AccessController.getContext


class Sikdang_main_tagAdapter(var context: Context, var tagList: List<TagLine>, var msgCat: MsgCat) : RecyclerView.Adapter<Sikdang_main_tagAdapter.Holder>() {
    var tagMax=18
    var tagNum=0
    var tagOrderList = Array(tagMax, {0})


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.sikdang_main_tagline, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int {
        return tagList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(tagList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var toggleBtn1= itemView?.findViewById<ToggleButton>(R.id.toggleBtn_tagline1)
        var toggleBtn2= itemView?.findViewById<ToggleButton>(R.id.toggleBtn_tagline2)
        var toggleBtn3= itemView?.findViewById<ToggleButton>(R.id.toggleBtn_tagline3)
        fun bind(item: TagLine, context:Context) {

            toggleBtn1?.text=item.tag1;
            toggleBtn1?.textOn=item.tag1;
            toggleBtn1?.textOff=item.tag1;
            //여기서 뭔가 넘겨줘야 함
            toggleBtn1?.setOnClickListener{
                var i=Int
                /*if (toggleBtn1.isChecked()){
                    msgCat.setListOn(item.tag1)
                }*/

                //Toast.makeText(getContext(), "item.tag1", Toast.LENGTH_SHORT).show()
            }
            //toggleBtn1.setOnCheckedChangeListener()

            toggleBtn2?.text=item.tag2;
            toggleBtn2?.textOn=item.tag2;
            toggleBtn2?.textOff=item.tag2;

            toggleBtn3?.text=item.tag3;
            toggleBtn3?.textOn=item.tag3;
            toggleBtn3?.textOff=item.tag3;

        }
    }




}