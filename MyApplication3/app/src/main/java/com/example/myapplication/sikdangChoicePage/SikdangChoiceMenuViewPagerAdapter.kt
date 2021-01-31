package com.example.myapplication.sikdangChoicePage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SikdangChoiceMenuViewPagerAdapter(fa:FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        //페이지수 리턴해야 함
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return SikdangChoiceMenuFragment()
    }
}