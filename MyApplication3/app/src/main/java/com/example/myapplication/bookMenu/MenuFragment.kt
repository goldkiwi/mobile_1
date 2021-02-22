package com.example.myapplication.bookMenu

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bookTable.TableData
import com.example.myapplication.bookTime.BookData

class MenuFragment: Fragment() {
    lateinit var bookData:BookData
    lateinit var menuData:MenuData
    lateinit var tableData: TableData

    var price = 0
    lateinit var priceTV : TextView

    lateinit var menuListRVAdapter:MenuListRVAdapter

    var tableNumAL=ArrayList<ArrayList<Int>>()
    var bookTableNum = 0
    //var tableNumString = ""//테이블

    var fAndTAL = ArrayList<Int>()//층, 테이블 번호, 층, 테이블 번호 반복

    var nowFloor = 0
    var nowTable = 0

    private var nowTableTab = 0
    var tableMenuList = ArrayList<ArrayList<Int>>()//테이블갯수 크기의 ArrayList가 있고 그 안에 메뉴갯수와 같은 크기의 ArrayList가 있음



    lateinit var tableNumText : TextView

    init{

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("확인 MenuFragment", "생성")
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater.inflate(R.layout.bookmenu_fragment, container, false)
        tableNumText = view.findViewById(R.id.tNumText)
        var bundle = getArguments()
        if (bundle != null) {
            bookData = bundle.getSerializable("bookData") as BookData
            menuData = bundle.getSerializable("menuData") as MenuData
            tableData = bundle.getSerializable("tableData") as TableData
            //Log.d("확인 MenuFragment", "2")
            //tableNumAR = (bundle.getParcelableArrayList("tabkeNumAR") as ArrayList<Int>?)!!
            //문제가 인트 리스트가 아니라 문자열로 넘어온다
            val tableNumList = bundle.getParcelableArrayList<Parcelable?>("tableNumAR")as ArrayList<Int>
            var tableNumString = bundle.getString("tableNumARString")
            //Log.d("확인 문자열로 넘어왔는지 확인", tableNumString.toString())
            var i = 0
            var j = 0
            var k = 0
            var tempString = tableNumString.toString()
            //Log.d("확인 MenuFragment 서브스트링 접근 확인", tempString)
            //Log.d("확인 MenuFragment 서브스트링 접근 확인", tempString.substring(5..5))

            //var tempString=""
            bookTableNum = 0
            while (i< tableNumList!!.size){//테이블 정보 받아온다
                //Log.d("확인 MenuFragment", tableNumList.size.toString()+" i 반복"+i.toString())
                //tempString+=tableNumList[i].toString()
                var tempNumAR:ArrayList<Int> =  ArrayList<Int>()
                while (tableNumString!!.substring(j..j) != "n"){
                    var tablePNum:Int = tableNumString!!.substring(j..j).toInt()
                    tempNumAR.add(tablePNum)
                    if (tablePNum != 0) bookTableNum ++
                    j++
                    //Log.d("확인 MenuFragment while (tableNumString!!.substring(j) != \"n\")", i.toString()+j.toString()+k.toString()+tableNumString!!.substring(j..j))
                }
                tableNumAL.add(tempNumAR)
                i++
                j++
                //Log.d("확인 MenuFragment while (tableNumString!!.substring(j) != \"n\")", "큰 와일문 끝")
            }

            //Log.d("확인 MenuFragment tableNumAR 넘어왔는지 확인", tempString)
        }
        else{
            Log.d("확인 MenuFragment bundle 받아오기", "else")
        }
        //Log.d("확인 MenuFragment", "2")

        alToAL()
        initTableMenuList()

        bind(view)
        return view
    }

    fun bind(itemView:View){
        //Log.d("확인 MenuFragment.bind", "1")

        tableNumText.setText(fAndTAL[nowTableTab*2].toString()+"층 테이블"+fAndTAL[nowTableTab*2+1].toString())


        //각 테이블별로 어떤 메뉴가 예약 되었는지 표시해주는 리사이클러뷰
        var tableRV : RecyclerView = itemView.findViewById(R.id.tableRV)
        var menuTableRVAdapter = MenuTableRVAdapter(this!!.getActivity()!!, menuData, bookTableNum, tableNumAL, tableData.floorList, fAndTAL,this)
        tableRV.adapter = menuTableRVAdapter
        //Log.d("확인 MenuFragment.bind", "2")

        var tableRVLayoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)
        tableRV.layoutManager=tableRVLayoutManager
        tableRV.setHasFixedSize(true)
        //Log.d("확인 MenuFragment.bind", "3")


        var menuListRV : RecyclerView = itemView.findViewById(R.id.menuListRV)
        menuListRVAdapter = MenuListRVAdapter(this!!.getActivity()!!, menuData, this)
        menuListRV.adapter = menuListRVAdapter

        var menuListRVLayoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)
        menuListRV.layoutManager = menuListRVLayoutManager
        menuListRV.setHasFixedSize(true)


        priceTV = itemView.findViewById(R.id.priceTV)
        setPriceText()

    }


    public fun alToAL(){
        //var floor = floorList[0]


        var i = 0
        var tempString = ""
        while (i < tableNumAL.size) {
            var floor = tableData.floorList[i]
            var j = 0
            var tempAR = ArrayList<Int>()
            while (j < tableNumAL[i].size) {
                if(tableNumAL[i][j] !=0) {
                    fAndTAL.add(floor)
                    tempString += floor.toString()
                    //fAndTAR.add(tableArrayList[i][j])
                    fAndTAL.add(j)
                    tempString += j.toString()
                }
                j++
            }
            i++
        }
        Log.d("확인 층수배열확인", tempString)


    }

    public fun setNowTableTab(pos:Int){
        nowTableTab = pos
    }


    public fun setTableText(floor:Int, tNum:Int){
        tableNumText.setText(floor.toString()+"층 테이블"+tNum.toString())
    }


    private fun initTableMenuList(){
        var i = 0
        while (i<bookTableNum){
            var tempAL = ArrayList<Int>()
            var j = 0
            while(j<menuData.menus.size){
                tempAL.add(0)
                j++
            }
            tableMenuList.add(tempAL)
            i++
        }
    }

    public fun setMenuPlus(menuNum:Int) {
        tableMenuList[nowTableTab][menuNum]++
        price+=menuData.menus[menuNum].price
        setPriceText()
    }
    public fun setMenuMinus(menuNum:Int){
        if (tableMenuList[nowTableTab][menuNum] > 0) {
            tableMenuList[nowTableTab][menuNum]--
            price-=menuData.menus[menuNum].price
            setPriceText()
        }
    }
    public fun getNowTableTab():Int{
        return nowTableTab
    }

    public fun turnMenuCount(){
        menuListRVAdapter.setMenuCountTVAL()
    }

    public fun setPriceText(){
        priceTV.setText(price.toString()+ "원")
    }



}