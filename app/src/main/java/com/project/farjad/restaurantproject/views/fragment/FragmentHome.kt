package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.tools.DataFackerGanerator
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.CommentAdapter
import com.project.farjad.restaurantproject.adapters.GhazaApadter
import com.project.farjad.restaurantproject.adapters.NoeGhazaAdapter
import com.project.farjad.restaurantproject.adapters.SliderAdapterHome
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.NoeGhaza
import com.project.farjad.restaurantproject.views.DetailActivity
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*

public class FragmentHome : Fragment()
    ,SliderAdapterHome.SliderEventListener
    ,GhazaApadter.onGhazaListListener
    ,NoeGhazaAdapter.onNoeGhazaListListener {


    lateinit var adapterNeoGhaza : NoeGhazaAdapter
    lateinit var adapterGhaza : GhazaApadter
    lateinit var adapterComment : CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTypeRecyclerView()
        initFoodsRecyclerView()
        initCommentRecyclerView()
        initSlider()
    }

    private fun initTypeRecyclerView(){
        adapterNeoGhaza = NoeGhazaAdapter(DataFackerGanerator.getNoeGahaza(),this)
        rcl_noe_foods.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        rcl_noe_foods.adapter = adapterNeoGhaza
    }

    private fun initFoodsRecyclerView(){
        adapterGhaza = GhazaApadter(DataFackerGanerator.getGhaza(),this)
        rcl_favorites_foods.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        rcl_favorites_foods.adapter = adapterGhaza
    }

    private fun initCommentRecyclerView(){
        adapterComment = CommentAdapter(DataFackerGanerator.getComments())
        rcl_last_comments.layoutManager =LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        rcl_last_comments.isNestedScrollingEnabled = false;
        rcl_last_comments.adapter = adapterComment
    }

    private fun initSlider() {
        val adapterHome = SliderAdapterHome(context, this)
        adapterHome.addItem(DataFackerGanerator.getGhaza()[1])
        adapterHome.addItem(DataFackerGanerator.getGhaza()[3])
        imageSlider.setSliderAdapter(adapterHome)
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.COLOR) //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        imageSlider.indicatorSelectedColor = Color.WHITE
        imageSlider.indicatorUnselectedColor = Color.GRAY
        imageSlider.scrollTimeInSec = 4 //set scroll delay in seconds :
        imageSlider.startAutoCycle()
    }

    override fun OnClickSlide(slidesHome: Ghaza?) {
        val intent = Intent(context,DetailActivity::class.java)
        intent.putExtra("food",slidesHome)
        startActivity(intent)
    }

    override fun onClickGhaza(ghaza: Ghaza) {
        val intent = Intent(context,DetailActivity::class.java)
        intent.putExtra("food",ghaza)
        startActivity(intent)
    }

    override fun onClickNeoGhaza(type: NoeGhaza) {
        Toast.makeText(context, type.name,Toast.LENGTH_SHORT).show()
    }
}