package com.example.myapplication.sikdangChoicePage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.recommendation.MsgCat

class SikdangChoice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.sikdangchoice)
        //msg객체를 넘겨받는다.
        var intent = getIntent()
        var cat = intent.getExtras()?.getString("msgCat")
        var catList = intent.getExtras()?.getStringArray("catList")
        //Log.d("확인 msgCat 생성? call?", "What_eat_today.onCreate")
        //var msgCat = intent.getParcelableExtra<MsgCat>("msgcat")
    }
}