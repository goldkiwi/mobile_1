package com.example.myapplication

import android.R.attr.data
import android.content.ClipData
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ExpandableListAdapter
import android.widget.LinearLayout
import android.widget.AdapterView





/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class baedal_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.baedal_main)

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





    }




/*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.baedal_main, container, false)
    }*/
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }*/
}



