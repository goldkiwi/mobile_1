package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Sikdang_main : AppCompatActivity() {
    var tagList_sm = arrayListOf<TagLine>();
    var bannerList_main = arrayListOf<Sikdang_main_banner>();
    private lateinit var viewPager2: ViewPager2
    //var main_tagList= findViewById<RecyclerView>(R.id.main_tagList);
    //var main_tagList: RecyclerView = findViewById(R.id.main_tagList);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sikdang_main)

        /// 메인 배너
        if (true) {
            var mainBanner: LinearLayout = findViewById(R.id.banner_ad);
            var bannerNum = 3;

            var i = 0;
            var bannerButtonParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            )
            while (i < bannerNum) {
                var addBanner = Button(this);
                addBanner.layoutParams = bannerButtonParams;
                addBanner.setBackgroundResource(R.drawable.add_main);
                mainBanner.addView(addBanner);

                i++;
            }
        }

        //음식 추천 태그
        if(true){
            var tagLineList : TagLineList= TagLineList();
            tagList_sm=tagLineList.getTagLineList()
            var tag_Adapter=Sikdang_main_tagAdapter(this, tagList_sm)
            var main_tagList: RecyclerView = findViewById(R.id.main_tagList);

            main_tagList.adapter=tag_Adapter;

            var tag_lm= LinearLayoutManager(this)
            main_tagList.layoutManager=tag_lm;
            main_tagList.setHasFixedSize(true)

        }


        if(true){

            var bannerList_sikdang_main : Sikdang_main_banner_list= Sikdang_main_banner_list();
            bannerList_main=bannerList_sikdang_main.getMainBannerList()



            //var banner_Adapter=Sikdang_main_bannerAdapter(this, bannerList_main)
            //var main_bannerList: ViewPager2 = findViewById(R.id.banner_view_pager);

            //main_bannerList.adapter=banner_Adapter;

            //var banner_lm= LinearLayoutManager(this)

            //main_bannerList.layoutManager=banner_lm;
            //main_bannerList.setHasFixedSize(true)




            //var banner_view_pager : ViewPager2 = findViewById(R.id.banner_view_pager);

            //banner_view_pager.adapter = Sikdang_main_bannerAdapter(this, bannerList_main)
            //banner_view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        }
        if(true){
            //var adapter = Sikdang_main_bannerAdapter(this, bannerList_main)
            //viewPager2 = findViewById(R.id.banner_view_pager)
            //viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            //viewPager2.adapter = adapter




        }





    }
    inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> BannerFragment(R.drawable.add_main_2)
                1 -> BannerFragment(R.drawable.add_main_3)
                else -> BannerFragment(R.drawable.add_main_4)
            }
        }
    }






}



