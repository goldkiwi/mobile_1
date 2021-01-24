package com.example.myapplication.mainPage
//카테고리 리스트 저장하는 함수
class CatList {
    //여기서 수정하면 카테고리 리스트 변함
    //2의 배수로 넣어야 함 아니면 끝에 하나 짤림
    private val cagArray = arrayListOf("소고기", "양식", "돼지고기", "면",
            "닭고기", "분식", "한식", "포차",
            "중식", "디저트", "일식", "프랜차이즈")

    public fun getCatArray(): ArrayList<String> {
        return cagArray
    }

}