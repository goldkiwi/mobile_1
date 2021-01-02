package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

private const val NUM_PAGE = 4
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
        Log.d("종료지점확인", "onCreate_30")




        /// 메인 배너
        if (true) {
            /*
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
            */




            var sikdang_main_banner_list : Sikdang_main_banner_list = Sikdang_main_banner_list();
            bannerList_main = Sikdang_main_banner_list().getMainBannerList();
            var bannerListAdapter = Sikdang_main_bannerAdapter(this, bannerList_main);
            var main_bannerList: RecyclerView = findViewById(R.id.main_banner);

            main_bannerList.adapter=bannerListAdapter


            var banner_lm=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            main_bannerList.layoutManager=banner_lm;
            main_bannerList.setHasFixedSize(true)

            bannerListAdapter.itemClick = object: Sikdang_main_bannerAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val whatEatToday_page=Intent(this@Sikdang_main, What_eat_today::class.java)
                    startActivity(whatEatToday_page)
                }
            }

            var bannerList_sikdang_main : Sikdang_main_banner_list= Sikdang_main_banner_list();
            bannerList_main=bannerList_sikdang_main.getMainBannerList()

            Toast.makeText(this.getApplicationContext(),
                    "EEEEEEEEEEEEE", Toast.LENGTH_SHORT).show()


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

        //뷰페이저 구현 실패

        if(true){
            /*
            Log.d("종료지점확인", "뷰페이저 시작 105")

            var bannerList_sikdang_main : Sikdang_main_banner_list= Sikdang_main_banner_list();
            bannerList_main=bannerList_sikdang_main.getMainBannerList()
            Log.d("종료지점확인", "111")

            var banner_Adapter=Sikdang_main_bannerAdapter(this, bannerList_main)
            var main_bannerList: ViewPager2 = findViewById(R.id.banner_view_pager);
            Log.d("종료지점확인", "116")

            main_bannerList.adapter=banner_Adapter;
            Log.d("종료지점확인", "119")

            var banner_lm= LinearLayoutManager(this)
            Log.d("종료지점확인", "122")

            //main_bannerList.layoutManager=banner_lm;
            //main_bannerList.setHasFixedSize(true)


            var banner_view_pager : ViewPager2 = findViewById(R.id.banner_view_pager);

            banner_view_pager.adapter = Sikdang_main_bannerAdapter(this, bannerList_main)
            banner_view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            Log.d("종료지점확인", "135")

             */

            var vp_slider : ViewPager2 = findViewById(R.id.banner_view_pager)
            var pagerAdapter = ScreenSlidePagerAdapter(this)
            vp_slider.adapter=pagerAdapter


            viewPager2=findViewById(R.id.banner_view_pager_2)
            var pagerAdapter2 = ScreenSlidePagerAdapter2(this)
            viewPager2.adapter=pagerAdapter2


        }


        if(true){
            /*
            var adapter = Sikdang_main_bannerAdapter(this, bannerList_main)
            viewPager2 = findViewById(R.id.banner_view_pager)
            viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            viewPager2.adapter = adapter*/


        }
        Log.d("종료지점확인", "153")



        var button_call_what_eat_today: Button = findViewById(R.id.button_whatEatToday)

        button_call_what_eat_today.setOnClickListener{
            val intent=Intent(this, What_eat_today::class.java)
            startActivity(intent)
        }

        Log.d("종료지점확인", "167")

        



    }

    override fun onBackPressed() {
        if (viewPager2.currentItem==0){
            super.onBackPressed()
        }else{
            viewPager2.currentItem=viewPager2.currentItem-1
        }
    }
    private inner class ScreenSlidePagerAdapter2(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGE

        override fun createFragment(position: Int): Fragment {
            return BannerSlideFragment()
        }
    }

    //뷰페이저 이것도 실패?
    inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment {
            Log.d("종료지점확인 ScreenSlidePagerAdapter", "179")

            if (position == 0){
                Log.d("종료지점확인 ScreenSlidePagerAdapter", "position == 0")
                return BannerFragment(R.drawable.add_main)
            }
            else if(position == 1){
                Log.d("종료지점확인 ScreenSlidePagerAdapter", "position == 1")
                return BannerFragment(R.drawable.add_main_2)
            }
            else if(position == 2){
                Log.d("종료지점확인 ScreenSlidePagerAdapter", "position == 2")
                return BannerFragment(R.drawable.add_main_3)
            }
            else{
                Log.d("종료지점확인 ScreenSlidePagerAdapter", "position == 3")
                return BannerFragment(R.drawable.add_main_4)
            }
            /*

            return when(position) {
                0 -> BannerFragment(R.drawable.add_main)
                1 -> BannerFragment(R.drawable.add_main_2)
                2 -> BannerFragment(R.drawable.add_main_3)
                else -> BannerFragment(R.drawable.add_main_4)
            }

             */
        }
    }






}



