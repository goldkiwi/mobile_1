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
    var firstCatCount = getCount(selectedCat)
    var lastBindCount = 0
    var isFirst = true


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
        holder.setIsRecyclable(false)
        holder.bind()
    }

    private fun getCount(catName: String?):Int{
        var count = 0
        var i = 0
        while (i<catArrayListSize){
            if (catName== this!!.catArrayList!![i]){
                break
            }
            i++
        }
        count = i
        return count
    }

    //맨 처음 선택된 카테고리만 킴




    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!){


        fun bind(){
            var sikdangChoice_toggleButton : ToggleButton = itemView.findViewById(R.id.sikdangchice_toggleButton)
            var catName: String? = catArrayList?.get(position)
            var catCount = getCount(catName)
            if (lastBindCount < catCount) lastBindCount = catCount
            sikdangChoice_toggleButton_arrayList[catCount] = (sikdangChoice_toggleButton)



            Log.d("종료지점확인 SikdangChoiceCatAdapter", "holder.bind()"+selectedCat+catName)

            if ((catName == selectedCat)&& (isFirst==true)){
                sikdangChoice_toggleButton.setChecked(true)
                toggleArrayList[firstCatCount] = true
                isFirst=false
            }
            sikdangChoice_toggleButton.text=catName
            sikdangChoice_toggleButton.textOn=catName
            sikdangChoice_toggleButton.textOff=catName
            if (selectedCat == catName){
                Log.d("확인 SikdangChoiceCatAdapter if ", selectedCat+catName)
                //sikdangChoice_toggleButton.toggle()
            }
            if (toggleArrayList[catCount] == true){
                sikdangChoice_toggleButton.setChecked(true)
            }
            else{
                sikdangChoice_toggleButton.setChecked(false)
            }
            //토글버튼을 ArrayList에 추가해 이 클래스 밖(SikdangChoice 클래스)에세 토글버튼을 사용할 수 있게 한다
            //onClickListener 사용해서 하나의 버튼이 켜지면 나머지 버튼은 꺼지도록 - 아예 SikdangChoice 클래스에서 구현핟고록 하는게 나을듯
            //sikdangChoice_toggleButton_arrayList.add(sikdangChoice_toggleButton)



            //토글 버튼 클릭했을 때

            sikdangChoice_toggleButton.setOnClickListener {
                Log.d("확인 sikdangChoice_toggleButton.setOnClickListener", "클릭")
                if (sikdangChoice_toggleButton.isChecked){//꺼진 버튼 누를 시 켜지고 다른 버튼 꺼지도록 한다
                    Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", "isChecked"+selectedCat+catName)
                    var i = 0
                    //catArrayListSize 를 넣으면 리사이클러뷰이기 때문에 아직 바인드하지 않은 부분까지 가서 에러발생
                    //현재 바인드 되있는 부분까지만 가야함
                    var catCount = getCount(catName)
                    while (i< sikdangChoice_toggleButton_arrayList.size){
                        Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", "와일문 돔"+i.toString() +"/"+sikdangChoice_toggleButton_arrayList.size.toString())
                        if(i != catCount){
                            toggleArrayList[i] = false//불리스트 수정
                            Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", i.toString()+" "+catArrayList?.get(i)+" "+"토글 오프")
                            if (lastBindCount>i)sikdangChoice_toggleButton_arrayList[i].isChecked=false//토글 끔
                            //Log.d("확인 SikdangChoiceCatAdapter   sikdangChoice_toggleButton.setOnCheckedChangeListener ", "isChecked 수정 후")
                        }
                        else if (i == catCount){
                            Log.d("확인 sikdangChoice_toggleButton.setOnClickListener", catArrayList?.get(i).toString() + "토글 온")
                            toggleArrayList[i] = true//불리스트 수정
                            if (lastBindCount>i)sikdangChoice_toggleButton_arrayList[i].isChecked=true
                        }
                        i++
                    }
                    Log.d("확인 sikdangChoice_toggleButton.setOnClickListener", "와일문 끝")



                }else{//이미 켜진 버튼 눌러도 변화 없도록 함
                    sikdangChoice_toggleButton.setChecked(true)
                }
                var i = 0
                var tempString=""
                Log.d("확인 sikdangChoice_toggleButton.setOnClickListener", "불배열 출력전")
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