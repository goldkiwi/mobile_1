package com.example.myapplication.payPage

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTable.TableFloorFragment

class PayPageCouponDialog(context: Context): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paypage_coupondialog)


        var couponListRV:RecyclerView = findViewById(R.id.couponListRV)
        var couponListRVAdapter = CouponListRVAdapter(context)
        couponListRV.adapter = couponListRVAdapter

        var couponListLM = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)//인원 버튼
        couponListRV.layoutManager=couponListLM
        couponListRV.setHasFixedSize(true)



    }
}