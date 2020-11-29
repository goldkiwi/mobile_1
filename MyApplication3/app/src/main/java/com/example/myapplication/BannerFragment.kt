package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.appcompat.app.AppCompatActivity

class BannerFragment(val image : Int) : Fragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fragment_banner : ImageView = view.findViewById(R.id.fragment_banner);
        fragment_banner.setImageResource(image)
    }
}