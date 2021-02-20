package com.example.myapplication.bookMenu

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MenuTableRVAdapter(var context: Context, var menuData:MenuData, val bookTableNum:Int,
                         val tableArrayList:ArrayList<ArrayList<Int>>, val floorList:ArrayList<Int>,val fAndTAL : ArrayList<Int>,  var menuFragment:MenuFragment) : RecyclerView.Adapter<MenuTableRVAdapter.Holder>()  {

    //var fAndTAL = ArrayList<Int>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("확인 MenuTableRVAdapter", "생성")
        val view = LayoutInflater.from(context).inflate(R.layout.bookmenu_eachtable, parent, false)
        //alToAL()
        return Holder(view)
    }

    override fun getItemCount(): Int {//리사이클러뷰에 몇개 들어갈것인가 : 테이블 수만큼
        return bookTableNum
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    /*
    public fun alToAL(){
        //var floor = floorList[0]


        var i = 0
        var tempString = ""
        while (i < tableArrayList.size) {
            var floor = floorList[i]
            var j = 0
            var tempAR = ArrayList<Int>()
            while (j < tableArrayList[i].size) {
                if(tableArrayList[i][j] !=0) {
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

    }*/

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        public fun bind(pos:Int){
            Log.d("확인 MenuTableRVAdapter", "Holder.bind")
            //테이블 번호
            var tableNumTV:TextView = itemView.findViewById(R.id.tableNumTV)
            tableNumTV.setText(fAndTAL[(pos*2)].toString()+"층 테이블"+fAndTAL[pos*2+1].toString())
            //Log.d("확인 MenuTableRVAdapter", "Holder.bind2")

            var tableMenuRV : RecyclerView = itemView.findViewById(R.id.tableMenuRV)
            //Log.d("확인 MenuTableRVAdapter", "Holder.bind2.1")
            var innerRVAdapter = InnerRVAdapter(context)
            //Log.d("확인 MenuTableRVAdapter", "Holder.bind2.2")
            tableMenuRV.adapter = innerRVAdapter
            //Log.d("확인 MenuTableRVAdapter", "Holder.bind3")

            var RVLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            tableMenuRV.layoutManager=RVLayoutManager
            tableMenuRV.setHasFixedSize(true)
            //eachtableLayout

            itemView.setOnClickListener(){//테이블 선택시 : 특정테이블 선택 - 여기에서 저장될 병수 : AllayList 등 지정
                Log.d("확인 MenuTableRVAdapter", "리사이클러뷰 클릭시")
                menuFragment.setTableText(fAndTAL[(pos*2)], fAndTAL[pos*2+1])
                menuFragment.setNowTableTab(pos)
            }

        }


        //리사이클러뷰 내부의 리사이클러뷰 어댑터
        //여기서는 각 테이블마다 어떤메뉴 골랐는지 바인드함 -> 실시간ㅁ으로 리사이클러뷰에 올라가야 한다
        //-> 함수 추가해야겠네

        inner class InnerRVAdapter(var innerContext: Context): RecyclerView.Adapter<InnerRVAdapter.InnerHolder>(){



            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerRVAdapter.InnerHolder {
                Log.d("확인 MenuTableRVAdapter.innerRVAdapter", "생성")
                //여기서 레이아웃은 메뉴 한줄이 들어가야 함
                val innerView = LayoutInflater.from(innerContext).inflate(R.layout.generalitem_button, parent, false)
                return InnerHolder(innerView)
            }

            //여기에는 각 테이블에 예약된 메뉴 몇종류인가가 들어가야 함
            //미리 상위에서 받아오는게 좋을듯 함
            override fun getItemCount(): Int {
                return 3
            }

            override fun onBindViewHolder(holder: InnerHolder, position: Int) {
                holder.innerBind(position)
            }

            inner class InnerHolder(innerView:View):RecyclerView.ViewHolder(innerView){
                public fun innerBind(pos:Int){
                    Log.d("확인 MenuTableRVAdapter.innerRVAdapter  innerBind", "생성")

                }

            }

        }

    }
}