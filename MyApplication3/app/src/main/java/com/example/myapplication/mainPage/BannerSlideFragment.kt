package com.example.myapplication.mainPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.addPage.*

class BannerSlideFragment(var bannerImage : Int, var pos : Int) : Fragment() {
    /*
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View= inflater.inflate(R.layout.banner_fragment, container, false)*/

    //버튼 id는 fragment_banner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var View= inflater.inflate(R.layout.banner_fragment, container, false)
        bind(View)

        View.setBackgroundResource(bannerImage)

        return View

    }

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null


    fun bind(itemView:View):View?{
        var banner_insert= itemView.findViewById<Button>(R.id.fragment_banner);
        banner_insert.setBackgroundResource(bannerImage)
        banner_insert.setOnClickListener{
            Log.d("종료지점확인", "BannerSlideFragment 버튼 클릭")
            //프래그먼트상에 context 존재하지 않기 때문에 getActivity() 사용
            val intent :Intent
            //
            when (pos){
                0-> {
                    intent=Intent(getActivity(), Add_page_0::class.java)
                    intent.putExtra("pos", 0)
                }
                1-> {
                    intent=Intent(getActivity(), Add_page_1::class.java)
                    intent.putExtra("pos", 1)
                }
                2-> {
                    intent=Intent(getActivity(), Add_page_2::class.java)
                    intent.putExtra("pos", 2)
                }
                3-> {
                    intent=Intent(getActivity(), Add_page_3::class.java)
                    intent.putExtra("pos", 3)
                }
                4-> {
                    intent=Intent(getActivity(), Add_page_4::class.java)
                    intent.putExtra("pos", 4)
                }
                5-> {
                    intent=Intent(getActivity(), Add_page_5::class.java)
                    intent.putExtra("pos", 5)
                }
                else -> {
                    intent=Intent(getActivity(), Add_page_1::class.java)
                    intent.putExtra("pos", 0)
                }
            }
            //intent=Intent(getActivity(), Add_page::class.java)
            startActivity(intent)
        }
        return itemView

    }


}