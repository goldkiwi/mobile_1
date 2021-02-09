package com.example.myapplication.bookTable

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTime.BookTime

class BookPersonDialog(context:Context, val pNum:Int, val tableFloorFragment: TableFloorFragment, val tableNum: Int): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.booktable_person_num_dialog)
        var bookPersonDialog =this
        var personNumRVAdapte = PersonNumRVAdapter(context, pNum, bookPersonDialog)
        var personNumRV:RecyclerView = findViewById(R.id.personNumRV)
        personNumRV.adapter = personNumRVAdapte

        var personNumLM = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)//인원 버튼
        personNumRV.layoutManager=personNumLM
        personNumRV.setHasFixedSize(true)

        var cancelButton = findViewById<Button>(R.id.cancelButton)//취소버튼
        cancelButton.setOnClickListener {
            cancelButtonClicked()
        }
        var dialogCloseButton = findViewById<Button>(R.id.dialogCloseButton)//닫기버튼
        dialogCloseButton.setOnClickListener {
            this.dismiss()
        }
        var menuChoiceButton = findViewById<Button>(R.id.menuChoiceButton)
        menuChoiceButton.setOnClickListener { //메뉴 선택 버튼

        }
    }
    fun buttonClicked(pNum:Int){
        tableFloorFragment.pNumButtonClicked(tableNum, pNum)
        //this.dismiss()
    }
    fun cancelButtonClicked(){
        tableFloorFragment.cancelButtonClicked(tableNum)
        this.dismiss()
    }


    interface BPDialogListener{
        fun onButtonClicked(){

        }
    }

}