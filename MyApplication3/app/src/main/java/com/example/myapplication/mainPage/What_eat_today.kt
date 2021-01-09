package com.example.myapplication.mainPage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class What_eat_today: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("종료지점확인", "What_eat_today 11")
        setContentView(R.layout.what_eat_today)

    }
}