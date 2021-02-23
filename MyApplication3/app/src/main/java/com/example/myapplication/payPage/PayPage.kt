package com.example.myapplication.payPage

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class PayPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("확인 PayPage", "1")
        setContentView(R.layout.paypage)
        Log.d("확인 PayPage", "2")
        var intent = getIntent()
    }

    override fun onStart() {
        super.onStart()
        Log.d("확인 PayPage", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("확인 PayPage", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("확인 PayPage", "onPause")
    }
}