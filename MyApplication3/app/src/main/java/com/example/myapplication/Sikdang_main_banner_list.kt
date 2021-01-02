package com.example.myapplication

import android.util.Log

class Sikdang_main_banner_list {
    var bannerList:ArrayList<Sikdang_main_banner> = arrayListOf(
        Sikdang_main_banner(R.drawable.add_main),
        Sikdang_main_banner(R.drawable.add_main_2),
        Sikdang_main_banner(R.drawable.add_main_3),
        Sikdang_main_banner(R.drawable.add_main_4)



    )

    fun getMainBannerList(): ArrayList<Sikdang_main_banner>{
        Log.d("종료지점확인 Sikdang_main_banner_list", "17")
        return bannerList;
    }
}