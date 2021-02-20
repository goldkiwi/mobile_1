package com.example.myapplication.bookMenu

import com.example.myapplication.R
import java.io.Serializable


//BookTime 액티비티에서 초기화
class MenuData(val sikdangId:Int): Serializable {

    public var menus =  ArrayList<Menu>()

    init{
        setMenuData()
    }


   public fun setMenuData(){
       var ings = ArrayList<Ingredient>()
       ings.add(Ingredient("파인애플", "하와이"))
       ings.add(Ingredient("피자", "피자헛"))

       menus.add(Menu("파인애플피자", 19000, "파인애플이 들어간 피자",R.drawable.foodimage, ings))

       var ings2 = ArrayList<Ingredient>()
       ings.add(Ingredient("민트", "치약"))
       ings.add(Ingredient("초코", "가나쬬꼬렛"))
       ings.add(Ingredient("피자", "도미노피자"))

       menus.add(Menu("민트초코피자", 30000,"민트초코가 들어간 피자", R.drawable.foodimage, ings2))

       var ings3 = ArrayList<Ingredient>()
       ings.add(Ingredient("보리", "보리쌀"))
       ings.add(Ingredient("콜라", "펩시"))

       menus.add(Menu("맥콜", 1500, "보리가 들어간 콜라",R.drawable.foodimage, ings3))

       var ings4 = ArrayList<Ingredient>()
       ings.add(Ingredient("솔잎", "집앞"))
       ings.add(Ingredient("물", "제주도 맑은샘물"))

       menus.add(Menu("솔의눈", 560, "솔잎이 들어간 물",R.drawable.foodimage, ings4))

       var ings5 = ArrayList<Ingredient>()
       ings.add(Ingredient("솔잎", "집앞"))
       ings.add(Ingredient("물", "제주도 맑은샘물"))

       menus.add(Menu("솔의눈", 560, "솔잎이 들어간 물",R.drawable.foodimage, ings4))



   }

    inner class Menu(var name:String, var price:Int, var menuExp:String, var menuImage:Int, var ingredients:ArrayList<Ingredient>)
    inner class Ingredient(var ing:String, var country:String)//식재료와 원산지
}