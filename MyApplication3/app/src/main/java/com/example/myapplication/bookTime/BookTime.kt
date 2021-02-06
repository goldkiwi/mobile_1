package com.example.myapplication.bookTime

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import com.example.myapplication.bookTable.TableFragment

//아예 시간표는 프래그먼트로 넣을까?

class BookTime: AppCompatActivity() {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()


    lateinit var bookData :BookData
    var fragmentPage = 0

    //var tableFragment = TableFragment()
    var timeFragment = TimeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booktime)
        Log.d("확인 BookTime", "onCreate")
        //식당 id 불러와서 BookTimeData에 데이터 set
        var sikdangId = intent.getExtras()!!.getInt("sikdangId")
        bookData = BookData(sikdangId)


        //식당 이미지 set
        var sikdangIV:ImageView = findViewById(R.id.bookTime_sikdangImage)
        sikdangIV.setBackgroundResource(bookData.getSikdangImage())

        //식당 이름 set
        var sikdangName: TextView = findViewById(R.id.bookTime_sikdangName)
        sikdangName.setText(bookData.getSikdangName()+bookData.getSikdangId().toString())

        //시간표 리사이클러뷰에 바인드
        /*
        var bookTimeRV:RecyclerView = findViewById(R.id.bookTimeRV)
        var bookTimeRVAdapter = BookTimeRVAdapter(this, bookTimeData)

        bookTimeRV.adapter = bookTimeRVAdapter

        var sikdangChice_catLineLM = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bookTimeRV.layoutManager=sikdangChice_catLineLM
        bookTimeRV.setHasFixedSize(true)*/

        //showBookTime(bookTimeData)

        replaceTimeFragment(timeFragment)
        /*
        var bundle:Bundle = Bundle()
        bundle.putSerializable("bookData", bookData)
        timeFragment.setArguments(bundle)
        fragmentPage=1

        fragmentTransaction.replace(R.id.bookFragment, timeFragment).commit()*/

        //fragmentTransaction.replace(R.id.bookFragment, timeFragment)

        //fragmentTransaction.add(R.id.bookFragment, timeFragment)
        //fragmentTransaction.commit()








    }
    public fun replaceTimeFragment(timeFragment: Fragment) {
        fragmentPage=1
        var bundle:Bundle = Bundle()
        bundle.putSerializable("bookData", bookData)
        timeFragment.setArguments(bundle)
        //val fragmentManager = supportFragmentManager
        val fragmentTransaction2 = fragmentManager.beginTransaction()

        fragmentTransaction2.replace(R.id.bookFragment, timeFragment).commit()
    }

    //테이블 프래그먼트 호출하는 함수
    public fun replaceTableFragment() {
        var tableFragment = TableFragment()
        fragmentPage = 2
        var bundle:Bundle = Bundle()
        bundle.putSerializable("bookData", bookData)
        tableFragment.setArguments(bundle)
        val fragmentTransaction3 = fragmentManager.beginTransaction()
        fragmentTransaction3.replace(R.id.bookFragment, tableFragment).commit()
    }


    //그 뭐냐 그 뒤로가기 버튼 눌으면 전 프래그먼트로 돌아가게 해야함
    override fun onBackPressed() {
        if (fragmentPage == 1){
            Log.d("확인 onBackPressed", fragmentPage.toString())
            super.onBackPressed()
        }
        else if(fragmentPage == 2){
            Log.d("확인 onBackPressed", fragmentPage.toString())
            replaceTimeFragment(timeFragment)
        }
        else {
            Log.d("확인 onBackPressed", fragmentPage.toString())
            super.onBackPressed()
        }
    }




/*
    public fun showBookTime(bookTimeData:BookTimeData){
        val transaction = manager.beginTransaction()
        val fragment = BookTimeFragment(bookTimeData)
        transaction.add(R.id.bookfragment, fragment)
        transaction.commit()

    }*/
}