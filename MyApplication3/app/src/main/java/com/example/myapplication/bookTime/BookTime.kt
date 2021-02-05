package com.example.myapplication.bookTime

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTable.TableFragment

//아예 시간표는 프래그먼트로 넣을까?

class BookTime: AppCompatActivity() {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booktime)
        Log.d("확인 BookTime", "onCreate")
        //식당 id 불러와서 BookTimeData에 데이터 set
        var sikdangId = intent.getExtras()!!.getInt("sikdangId")
        val bookTimeData = BookTimeData(sikdangId)


        //식당 이미지 set
        var sikdangIV:ImageView = findViewById(R.id.bookTime_sikdangImage)
        sikdangIV.setBackgroundResource(bookTimeData.getSikdangImage())

        //식당 이름 set
        var sikdangName: TextView = findViewById(R.id.bookTime_sikdangName)
        sikdangName.setText(bookTimeData.getSikdangName()+bookTimeData.getSikdangId().toString())

        //시간표 리사이클러뷰에 바인드
        /*
        var bookTimeRV:RecyclerView = findViewById(R.id.bookTimeRV)
        var bookTimeRVAdapter = BookTimeRVAdapter(this, bookTimeData)

        bookTimeRV.adapter = bookTimeRVAdapter

        var sikdangChice_catLineLM = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bookTimeRV.layoutManager=sikdangChice_catLineLM
        bookTimeRV.setHasFixedSize(true)*/

        //showBookTime(bookTimeData)
        var bookTimeData2=BookTimeData(sikdangId)

        val fragment = TimeFragment()

        fragmentTransaction.add(R.id.bookFragment, fragment)
        //fragmentTransaction.commit()







    }


/*
    public fun showBookTime(bookTimeData:BookTimeData){
        val transaction = manager.beginTransaction()
        val fragment = BookTimeFragment(bookTimeData)
        transaction.add(R.id.bookfragment, fragment)
        transaction.commit()

    }*/
}