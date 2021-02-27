package com.example.myapplication.payPage

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.bookMenu.DataMenuToPay
import com.example.myapplication.bookTable.TableData
import com.example.myapplication.bookTime.BookData

class PayPage: AppCompatActivity() {
    lateinit var dataMenuToPay:DataMenuToPay
    var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("확인 PayPage", "1")
        setContentView(R.layout.paypage)
        //Log.d("확인 PayPage", "2")

        var intent = getIntent()
        if (intent != null) {
            dataMenuToPay = intent.getSerializableExtra("dataMenuToPay") as DataMenuToPay
            price = intent.getIntExtra("price", 0)
            //Log.d("확인 PayPage", "price 확인"+price.toString())

        }
        else{
            Log.d("확인 PayPage", "intent 데이터 가져오기 오류")
        }
        var payPageSikdangName:TextView = findViewById(R.id.payPageSikdangName)
        payPageSikdangName.setText(dataMenuToPay.sikdangName)

        var reqEditText:EditText = findViewById(R.id.reqEditText)
        reqEditText.setSingleLine(false)


        var payPageOriginalPrice:TextView = findViewById(R.id.payPageOriginalPrice)
        payPageOriginalPrice.setText(price.toString()+"원")

    }


}