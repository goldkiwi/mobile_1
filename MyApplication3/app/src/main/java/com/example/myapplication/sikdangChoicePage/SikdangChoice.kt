package com.example.myapplication.sikdangChoicePage

import android.os.Bundle
import android.util.Log
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recommendation.MsgCat

class SikdangChoice : AppCompatActivity() {
    var sikdangChoice_toggleButton_arrayList = ArrayList<ToggleButton>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.sikdangchoice)
        Log.d("종료지점확인 SikdangChoice", "레이아웃 호출")

        //msg객체를 넘겨받는다.
        var intent = getIntent()
        var cat = intent.getExtras()?.getString("msgCat")
        var catArrayList: ArrayList<String>? = intent.getExtras()?.getStringArrayList("catArrayList")
        Log.d("종료지점확인 SikdangChoice", "intent 받음")
        //Log.d("확인 msgCat 생성? call?", "What_eat_today.onCreate")
        //var msgCat = intent.getParcelableExtra<MsgCat>("msgcat")

        var sikdangChoiceCatAdapter = SikdangChoiceCatAdapter(this, catArrayList, sikdangChoice_toggleButton_arrayList)
        Log.d("종료지점확인 SikdangChoice", "1")
        var sikdangChoice_CatLine : RecyclerView = findViewById(R.id.sikdangChoice_catLine)
        Log.d("종료지점확인 SikdangChoice", "2")
        sikdangChoice_CatLine.adapter = sikdangChoiceCatAdapter
        Log.d("종료지점확인 SikdangChoice", "3")

        var sikdangChice_catLineLM = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        sikdangChoice_CatLine.layoutManager=sikdangChice_catLineLM
        sikdangChoice_CatLine.setHasFixedSize(true)


    }
}