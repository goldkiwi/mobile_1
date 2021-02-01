package com.example.myapplication.sikdangChoicePage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.R

//뷰페이저에 프래그먼트 바인드하는 클래스
class SikdangChoiceMenuViewPagerAdapter(fa:FragmentActivity) : FragmentStateAdapter(fa) {
    var repMenuArrayList : ArrayList<String> = arrayListOf("파인애플피자", "민트초코피자", "오이피자", "두리안피자")
    var anyList : ArrayList<Int> = arrayListOf(0, 0, 0, 0)

    override fun getItemCount(): Int {
        //페이지수 리턴해야 함
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        var sikdangChoiceMenuFragment = SikdangChoiceMenuFragment(R.drawable.foodimage, "음식점", repMenuArrayList, anyList)
        return sikdangChoiceMenuFragment
    }
}