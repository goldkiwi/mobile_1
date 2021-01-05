package mainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class BannerSlideFragment(var bannerImage : Int) : Fragment() {
    /*
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View= inflater.inflate(R.layout.banner_fragment, container, false)*/

    //버튼 id는 fragment_banner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //view?.let { super.onViewCreated(it, savedInstanceState) }
        //var banner_insert= View.findViewById<Button>(R.id.banner_button);
        var View= inflater.inflate(R.layout.banner_fragment, container, false)
        //var fragmentBanner : ImageView = view!!.findViewById(R.id.fragment_banner);
        //fragmentBanner.setImageResource(R.id.add_main_2)
        bind(View)

        View.setBackgroundResource(bannerImage)

        return View

    }
    fun bind(itemView:View):View?{
        var banner_insert= itemView.findViewById<Button>(R.id.fragment_banner);
        banner_insert.setBackgroundResource(bannerImage)
        return itemView

    }


}