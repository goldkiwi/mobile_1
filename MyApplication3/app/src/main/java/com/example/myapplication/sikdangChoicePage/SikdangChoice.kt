package com.example.myapplication.sikdangChoicePage

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recommendation.MsgCat

class SikdangChoice : AppCompatActivity() {
    //리스트는 SikdangChoiceCatAdapter 클래스의 inner class인 Holder 클래스의 bind()함수에서 칵 카테고리의 toggle 버튼으로 채워준다
    var sikdangChoice_toggleButton_arrayList = ArrayList<ToggleButton>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.sikdangchoice)
        Log.d("종료지점확인 SikdangChoice", "레이아웃 호출")

        //msg객체를 넘겨받는다.
        var intent = getIntent()
        var selectedCat = intent.getExtras()?.getString("cat")
        //카테고리의 이름들 ArrayList 형태로 넘겨받는다 (소고기, 돼지고기, 닭고기....)
        var catArrayList: ArrayList<String>? = intent.getExtras()?.getStringArrayList("catArrayList")
        Log.d("종료지점확인 SikdangChoice", "intent 받음")

        //어댑터 사용한다

        var sikdangChoiceCatAdapter = SikdangChoiceCatAdapter(this, catArrayList, sikdangChoice_toggleButton_arrayList, selectedCat.toString())
        Log.d("종료지점확인 SikdangChoice", "sikdangChoiceCatAdapter")
        //sikdangChoiceCatAdapter.setHasStableIds(true)
        var sikdangChoice_CatLine : ListView = findViewById(R.id.sikdangChoice_catLine)
        Log.d("종료지점확인 SikdangChoice", "sikdangChoice_CatLine")
        sikdangChoice_CatLine.adapter = sikdangChoiceCatAdapter
        Log.d("종료지점확인 SikdangChoice", "sikdangChoice_CatLine.adapter = sikdangChoiceCatAdapter")

        //var sikdangChice_catLineLM = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //sikdangChoice_CatLine.layoutManager=sikdangChice_catLineLM
        //sikdangChoice_CatLine.setHasFixedSize(true)


    }
}