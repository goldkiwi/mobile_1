package com.example.myapplication.bookTable

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTime.BookTime

class BookPersonDialog(context:Context, val pNum:Int, val tableFloorFragment: TableFloorFragment): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.booktable_person_num_dialog)
        var bookPersonDialog =this
        var personNumRVAdapte = PersonNumRVAdapter(context, pNum, bookPersonDialog)
        var personNumRV:RecyclerView = findViewById(R.id.personNumRV)
        personNumRV.adapter = personNumRVAdapte

        var personNumLM = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        personNumRV.layoutManager=personNumLM
        personNumRV.setHasFixedSize(true)
    }
    fun buttonClicked(tableNum:Int, pNum:Int){
        tableFloorFragment.pNumButtonClicked(tableNum, pNum)
    }
    fun cancelButtonClicked(tableNum: Int){
        tableFloorFragment.cancelButtonClicked(tableNum)
    }


    interface BPDialogListener{
        fun onButtonClicked(){

        }
    }

}