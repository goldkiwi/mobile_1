package com.example.myapplication.bookTable

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
//TableFragment에서 사용
class TableVPAdapter(fa:FragmentActivity): FragmentStateAdapter(fa) {
    //총 몇층인가
    override fun getItemCount(): Int {
        Log.d("확인 TableVPAdapter", "getItemCount()")
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        Log.d("확인 TableVPAdapter", "createFragment(position: Int)")
        var tableFloorFragment=TableFloorFragment()
        return tableFloorFragment
    }
}