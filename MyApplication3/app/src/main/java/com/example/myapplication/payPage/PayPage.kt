package com.example.myapplication.payPage

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.bookMenu.DataMenuToPay
import com.example.myapplication.bookTable.BookPersonDialog
import com.example.myapplication.bookTable.TableData
import com.example.myapplication.bookTime.BookData

class PayPage: AppCompatActivity() {
    lateinit var dataMenuToPay:DataMenuToPay
    var price = 0
    var checkBoxAL = ArrayList<CheckBox>()
    var couponData = CouponData(getUserId())

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


        //쿠폰 관련 부분
        var couponTV = findViewById<TextView>(R.id.couponTV)
        couponTV.setOnClickListener {
            showDialog()
        }














        checkBoxAL.add(findViewById(R.id.kakaoPayCB))
        checkBoxAL.add(findViewById(R.id.secondPayCB))

        //while 문으로 돌리면 마지감 i값이 들어가서 문제 생김 : 일일이 코드로 넣어줘야함
        //어차피 페이 종류 많이 안넣을테니 일일이 넣어도 상관 없음
        checkBoxAL[0].setOnClickListener {
            var j = 0
            while(j<checkBoxAL.size){
                if (0!=j){
                    checkBoxAL[j].isChecked = false
                }
                j++
            }
        }
        checkBoxAL[1].setOnClickListener {
            var j = 0
            while(j<checkBoxAL.size){
                if (1!=j){
                    checkBoxAL[j].isChecked = false
                }
                j++
            }
        }





        /*
        var i = 0
        while(i < checkBoxAL.size){//하나 체크되면 나머지 체크 끈다
            Log.d("확인 PayPage checkBox 배당", i.toString())
            checkBoxAL[i].setOnClickListener {
                var count = 0
                count+=i
                var j = 0
                Log.d("확인 PayPage checkBox 내부 배당", count.toString()+j.toString())
                while(j<checkBoxAL.size){
                    if (count!=j){
                        Log.d("확인 PayPage checkBox 확인", count.toString()+j.toString())
                        checkBoxAL[j].isChecked = false
                    }
                    Log.d("확인 PayPage checkBox 재확인", count.toString()+j.toString())
                    j++
                }
            }
            i++
        }*/

    }

    //유저아이디 어디서 얻을지 정해야 한다
    public fun getUserId():Int{
        return 987654321
    }

    public fun showDialog(){
        var customDialog = PayPageCouponDialog(this)
        customDialog!!.show()
    }


}