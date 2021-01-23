package com.example.myapplication.mainPage

class CatList {
    private val cagArray = arrayListOf("소고기", "양식", "돼지고기", "면",
            "닭고기", "분식", "한식", "포차",
            "중식", "디저트", "일식", "프랜차이즈")

    public fun getCatArray(): ArrayList<String> {
        return cagArray
    }

}