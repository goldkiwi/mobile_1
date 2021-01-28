package com.example.myapplication.sikdangChoicePage

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class SikdangChoiceCatAdapter(var context : Context, val catArrayList: ArrayList<String>?,
                              var sikdangChoice_toggleButton_arrayList: ArrayList<ToggleButton>,
                              var selectedCat :String) : RecyclerView.Adapter<SikdangChoiceCatAdapter.Holder>() {
    var catArrayListSize = catArrayList?.size!!
    var toggleArrayList= Array<Boolean>(catArrayListSize, {false})
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //Log.d("종료지점확인 SikdangChoiceCatAdapter", "onCreateViewHolder 시작")
        val view = LayoutInflater.from(context).inflate(R.layout.sikdangchoice_cat, parent, false)
        //Log.d("종료지점확인 SikdangChoiceCatAdapter", "onCreateViewHolder 2")
        return Holder(view)
    }

    override fun getItemCount(): Int {
        //Log.d("종료지점확인 SikdangChoiceCatAdapter", "getItempCount()")
        //Log.d("종료지점확인 SikdangChoiceCatAdapter", "getItempCount()"+catArrayList?.size.toString())
        return catArrayListSize
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //리사이클러뷰 성능 위해 재사용하기 떄문에 재사용 하지 못하게 해줘야 한다
        //holder.setIsRecyclable(false)
        holder.bind()
    }


    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        var sikdangChoice_toggleButton : ToggleButton = itemView?.findViewById(R.id.sikdangchice_toggleButton)!!

        fun bind(){
            if(sikdangChoice_toggleButton.isChecked){
                sikdangChoice_toggleButton.setChecked(true)
            }
            else{
                sikdangChoice_toggleButton.setChecked(false)
            }

            var catName: String? = catArrayList?.get(position)
            Log.d("종료지점확인 SikdangChoiceCatAdapter", "holder.bind()"+selectedCat+catName)
            sikdangChoice_toggleButton.text=catName
            sikdangChoice_toggleButton.textOn=catName
            sikdangChoice_toggleButton.textOff=catName
            if (selectedCat == catName){
                Log.d("확인 SikdangChoiceCatAdapter if ", selectedCat+catName)
                //sikdangChoice_toggleButton.toggle()
            }
            //토글버튼을 ArrayList에 추가해 이 클래스 밖(SikdangChoice 클래스)에세 토글버튼을 사용할 수 있게 한다
            //onClickListener 사용해서 하나의 버튼이 켜지면 나머지 버튼은 꺼지도록 - 아예 SikdangChoice 클래스에서 구현핟고록 하는게 나을듯
            //sikdangChoice_toggleButton_arrayList.add(sikdangChoice_toggleButton)
            /*
            sikdangChoice_toggleButton.setOnClickListener {

            }*/



            sikdangChoice_toggleButton.setOnCheckedChangeListener{ _, isChecked ->
                if (isChecked){
                    Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", "isChecked"+selectedCat+catName)
                    var i = 0
                    while (i< catArrayListSize){
                        if (catArrayList?.get(i) == catName){
                            toggleArrayList[i] = true
                        }
                        i++
                    }


                    //여기서 다른 토글버튼 모두 끄고 이 버튼에 맞는 프래그먼트 아래쪽에 불러온다
                }else{
                    var i = 0
                    while (i< catArrayListSize){
                        if (catArrayList?.get(i) == catName){
                            toggleArrayList[i] = false
                        }
                        i++
                    }
                    Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", "else"+selectedCat+catName)
                    //sikdangChoice_toggleButton.toggle()
                }
                var i = 0
                var tempString=""
                while (i< catArrayListSize){
                    if (toggleArrayList[i] == true){
                        tempString+="1"
                    }
                    else{
                        tempString+="0"
                    }
                    i++
                }
                Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", "불배열확인"+tempString)

            }
        }

    }
}