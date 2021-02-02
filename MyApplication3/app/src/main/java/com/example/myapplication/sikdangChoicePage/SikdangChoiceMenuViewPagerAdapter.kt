package com.example.myapplication.sikdangChoicePage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.R

//뷰페이저에 프래그먼트 바인드하는 클래스
//프래그먼트 몇개 넣을지, 매뉴의 어댑터 매개변수로 받음
//매뉴 어댑터 받아서 메뉴 어댑터의 스크롤 함수르 호출한다
class SikdangChoiceMenuViewPagerAdapter(fa:FragmentActivity, val catArrayList : ArrayList<String>) : FragmentStateAdapter(fa) {
    var repMenuArrayList : ArrayList<String> = arrayListOf("파인애플피자", "민트초코피자", "오이피자", "두리안피자")
    var anyList : ArrayList<Int> = arrayListOf(0, 0, 0, 0)


    override fun getItemCount(): Int {
        //페이지수 리턴해야 함
        return catArrayList.size
    }

    override fun createFragment(position: Int): Fragment {
        var sikdangChoiceMenuFragment = SikdangChoiceMenuFragment(R.drawable.foodimage, catArrayList[position], repMenuArrayList, anyList)
        return sikdangChoiceMenuFragment
    }




}