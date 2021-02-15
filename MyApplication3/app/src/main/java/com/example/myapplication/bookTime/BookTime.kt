package com.example.myapplication.bookTime

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.bookMenu.MenuData
import com.example.myapplication.bookMenu.MenuFragment
import com.example.myapplication.bookTable.TableFragment


//아예 시간표는 프래그먼트로 넣을까?

class BookTime: AppCompatActivity() {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()


    lateinit var bookData :BookData
    lateinit var menuData: MenuData
    var fragmentPage = 0

    //var tableFragment = TableFragment()
    var timeFragment = TimeFragment()
    //var menuFragment = MenuFragment()

    //TableFloorFragment에서 받아와 MenuFragment로 전달하는 데이터
    //몇페이지인가와 그 페이지의 테이블 정보를 가져와서 리스트에 추가한다
    var isTableInfoInit : Boolean = false
    var tablePage = ArrayList<Int>()
    var tableNumAR=ArrayList<ArrayList<Int>>()//각 층의 각 테이블에 몇명 예약했는지를 저장하는 리스트
    var tableNumARString=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booktime)
        Log.d("확인 BookTime", "onCreate")
        //식당 id 불러와서 BookTimeData에 데이터 set
        var sikdangId = intent.getExtras()!!.getInt("sikdangId")
        bookData = BookData(sikdangId)
        menuData = MenuData(sikdangId)


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

    public fun replaceMenuFragment() {
        var menuFragment = MenuFragment()
        fragmentPage = 3
        var bundle:Bundle = Bundle()
        bundle.putSerializable("bookData", bookData)
        bundle.putSerializable("menuData", menuData)
        Log.d("확인 replaceMenuFragment ArrayList.Tostring ", tableNumAR.toString())

        bundle.putParcelableArrayList("tableNumAR", tableNumAR as ArrayList<out Parcelable?>?)
        //bundle.putSerializableExtras()
        //bundle.putString("tableNumAR", tableNumAR.toString())
        menuFragment.setArguments(bundle)
        val fragmentTransaction4 = fragmentManager.beginTransaction()

        fragmentTransaction4.replace(R.id.bookFragment, menuFragment).commit()

    }


    //그 뭐냐 그 뒤로가기 버튼 눌으면 전 프래그먼트로 돌아가게 해야함
    //전 프래그먼트로 돌아갈 시 데이터 없어짐 - 데이터 이어지도록 해야 함 - 좀 나중으로 미룸?

    override fun onBackPressed() {
        if (fragmentPage == 1){
            Log.d("확인 onBackPressed", fragmentPage.toString())
            super.onBackPressed()
        }
        else if(fragmentPage == 2){
            Log.d("확인 onBackPressed", fragmentPage.toString())
            replaceTimeFragment(timeFragment)
        }
        else if(fragmentPage == 3){
            Log.d("확인 onBackPressed", fragmentPage.toString())
            replaceTableFragment()
        }
        else {
            Log.d("확인 onBackPressed", fragmentPage.toString())
            super.onBackPressed()
        }
    }

    //TableFloorFragment에서 호출
    //페이지와 그 페이지의 각 테이블에 몇명 앉는가의 정보를 받아온다
    //매번 데이터를 받아와햐하는데 그러려변 미리 ArrayList가 초기화되어있어야 한다
    //TableFragment 에서 총 몇층인지, 각 층의 테이블이 몇개인지 매개변수로 전달받아 초기화
    public fun tableInfoInit(floorNum:Int, tableNum:ArrayList<Int>){//이건 아마 TableFragment에서 호출해야할듯
        var i = 0
        if (isTableInfoInit == false) {
            while (i < floorNum) {
                var j = 0
                var tempAR = ArrayList<Int>()
                while (j < tableNum[i]) {
                    tempAR.add(0)
                    tableNumARString+=0.toString()
                    j++
                }
                tableNumARString+="n"
                tableNumAR.add(tempAR)
                i++
            }
            Log.d("확인 BookTime.TableNumAR", "초기화")
            Log.d("확인 BookTime.TableNumARStraing", tableNumARString)
            logTableNumAR()
        }
        isTableInfoInit = true//초기화 끝나고 다시 안바뀌도록 한다
    }

    public fun setTableInfoToString(){
        Log.d("확인 BookTime.setTableInfoToString() 문자열 변환 확인", "시작")
        var i = 0
        var k = 0
        var tempString = ""
        while (i < tableNumAR.size) {
            var j = 0
            var tempAR = ArrayList<Int>()
            while (j < tableNumAR[i].size) {
                //tableNumARString[k] = tableNumAR[i][j]
                tempString+= tableNumAR[i][j].toString()
                j++
                //k++
            }
            tempString+="n"
            //k++
            i++
        }
        tableNumARString = tempString
        Log.d("확인 BookTime.setTableInfoToString() 문자열 변환 확인", tableNumARString)
        logTableNumAR()


    }

    public fun setTableInfo(tablePage_:Int, tableNumAR_:ArrayList<Int>){
        //tablePage.add(tablePage_)
        tableNumAR[tablePage_] = tableNumAR_
        var i = 0
        setTableInfoToString()
        logTableNumAR()
    }

    private fun logTableNumAR(){
        var i = 0
        var logString=""
        while(i<tableNumAR.size){
            var j = 0
            while (j<tableNumAR[i].size){
                logString+=tableNumAR[i][j].toString()
                j++
            }
            i++
        }
        Log.d("확인 BookTime.TableNumAR", logString)

    }




/*
    public fun showBookTime(bookTimeData:BookTimeData){
        val transaction = manager.beginTransaction()
        val fragment = BookTimeFragment(bookTimeData)
        transaction.add(R.id.bookfragment, fragment)
        transaction.commit()

    }*/
}