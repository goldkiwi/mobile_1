package mainPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.*
import mainPage.What_eat_today

private const val NUM_PAGE = 5
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Sikdang_main : AppCompatActivity() {
    var tagList_sm = arrayListOf<TagLine>();
    private lateinit var viewPager2: ViewPager2

    private var num_page = 4



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sikdang_main)
        Log.d("종료지점확인", "onCreate_30")




        //음식 추천 태그
        if(true){
            var tagLineList : TagLineList = TagLineList();
            tagList_sm=tagLineList.getTagLineList()
            var tag_Adapter= Sikdang_main_tagAdapter(this, tagList_sm)
            var main_tagList: RecyclerView = findViewById(R.id.main_tagList);

            main_tagList.adapter=tag_Adapter;

            var tag_lm= LinearLayoutManager(this)
            main_tagList.layoutManager=tag_lm;
            main_tagList.setHasFixedSize(true)

        }

        //뷰페이저

        if(true){


            viewPager2=findViewById(R.id.banner_view_pager_2)
            var pagerAdapter2 = ScreenSlidePagerAdapter2(this)
            viewPager2.adapter=pagerAdapter2


        }




        //오늘 뭐먹지? 누르면 페이지 호출
        //여기에 눌러진 버튼도 매개변수로 줘야함
        var button_call_what_eat_today: Button = findViewById(R.id.button_whatEatToday)

        button_call_what_eat_today.setOnClickListener{
            val intent=Intent(this, What_eat_today::class.java)
            Log.d("종료지점확인", "call What_eat_today")
            startActivity(intent)
            Log.d("종료지점확인", "End What_eat_today")
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

    //배너 어댑터
    //최대 6페이지까지
    private inner class ScreenSlidePagerAdapter2(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = num_page

        override fun createFragment(position: Int): Fragment {
            if (position == 0){
                return BannerSlideFragment(R.drawable.add_main)
            }else if(position == 1){
                return BannerSlideFragment(R.drawable.add_main_2)
            }else if(num_page >=3 && position == 2){
                return BannerSlideFragment(R.drawable.add_main_3)
            }else if(num_page >=4 && position == 3){
                return BannerSlideFragment(R.drawable.add_main_4)
            }else if(num_page >=5 && position == 4){
                return BannerSlideFragment(R.drawable.add_main_5)
            }else if(num_page >=6 && position == 5){
                return BannerSlideFragment(R.drawable.add_main_6)
            }else{
                return BannerSlideFragment(R.drawable.add_main)
            }

        }
    }






}



