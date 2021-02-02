package com.example.myapplication.sikdangChoicePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R

//리사이클러뷰에 어댑터 설정하는 클래스
class SikdangChoiceMenuFragment(var sikdangImage : Int, val sikdangName : String, val repMenuArrayList:ArrayList<String>, val anyList:ArrayList<Int>) :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        //view 는 리사이클러뷰 하나 들어있는 레이아웃
        var view= inflater.inflate(R.layout.sikdangchoice_menu_fragment, container, false)
        bind(view)

        //View.setBackgroundResource(bannerImage)

        return view
    }



    fun bind(itemView:View):View?{
        //itemView는 프래그먼트 자체
        //var sikdangchoice_menuline : LinearLayout = itemView.findViewById(R.id.sikdangChoiceMenuFragmentRecyclerView)
        var sikdangChoiceMenuFragmentRecyclerView : RecyclerView = itemView.findViewById(R.id.sikdangChoiceMenuFragmentRecyclerView)
        var sikdangChoiceMenuAdapter = SikdangChoiceMenuAdapter(this!!.getActivity()!!, sikdangName)
        sikdangChoiceMenuFragmentRecyclerView.adapter = sikdangChoiceMenuAdapter

        var sikdangChice_catLineLM = LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)
        sikdangChoiceMenuFragmentRecyclerView.layoutManager=sikdangChice_catLineLM
        sikdangChoiceMenuFragmentRecyclerView.setHasFixedSize(true)


        return itemView

    }

}