package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.CommentAdapter
import com.project.farjad.restaurantproject.adapters.GhazaApadter
import com.project.farjad.restaurantproject.adapters.NoeGhazaAdapter
import com.project.farjad.restaurantproject.adapters.SliderAdapterHome
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.BazKhord
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.HomeViewModel
import com.project.farjad.restaurantproject.views.AddFactorActivity
import com.project.farjad.restaurantproject.views.AddFoodActivity
import com.project.farjad.restaurantproject.views.FoodDetailActivity
import com.project.farjad.restaurantproject.views.ListReportActivity
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

public class FragmentHome : Fragment()
    ,SliderAdapterHome.SliderEventListener
    ,GhazaApadter.onGhazaListListener
    ,NoeGhazaAdapter.onNoeGhazaListListener {


    private lateinit var adapterNeoGhaza : NoeGhazaAdapter
    private lateinit var adapterGhaza : GhazaApadter
    private lateinit var adapterComment : CommentAdapter
    private val viewModel: HomeViewModel by lazy (LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao()))
            .get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allGhazas.observe(viewLifecycleOwner, Observer { foods->
            foods.forEach {
                it.type = viewModel.getTypeGhaza(it.id_noeGhaza)
            }
            initFoodsRecyclerView(foods)
            initSlider(foods)
        })
        viewModel.allNoeGhaza.observe(viewLifecycleOwner, Observer {
            initTypeRecyclerView(it)
        } )


        viewModel.typeFoodPrg.observe(viewLifecycleOwner, Observer {
            prg_home_type_food.visibility = if (it) { View.VISIBLE } else { View.GONE }
        })
        viewModel.foodPrg.observe(viewLifecycleOwner , Observer {
            prg_home_food.visibility = if (it) { View.VISIBLE } else { View.GONE }
        })

        viewModel.lastBazkhords.observe(viewLifecycleOwner, Observer {
            val allBaz: MutableList<BazKhord> = ArrayList()
            for (i in it.indices) {
                for (j in it[i].bazKhordList.indices) {
                    it[i].bazKhordList[j].nameMosh = it[i].moshtari.name
                    it[i].bazKhordList[j].nameGhaz = viewModel.getGhazaName(it[i].bazKhordList[j].idGhaza)
                    allBaz.add(it[i].bazKhordList[j])
                }
            }
            initCommentRecyclerView(allBaz)
        })

        btn_more_home.setOnClickListener {
            val popupMenu : PopupMenu = PopupMenu(context,btn_more_home)
            popupMenu.menuInflater.inflate(R.menu.menu_more_home,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_add_food->{ startActivity(Intent(context,AddFoodActivity::class.java))  }
                }
                true
            }
            popupMenu.show()
        }
    }

    private fun initTypeRecyclerView(noeGhaza: List<NoeGhazaWithGhaza>){
        adapterNeoGhaza = NoeGhazaAdapter(noeGhaza,this)
        rcl_noe_foods.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        rcl_noe_foods.adapter = adapterNeoGhaza
    }

    private fun initFoodsRecyclerView(ghaza: MutableList<Ghaza>){
        adapterGhaza = GhazaApadter(ghaza.subList(0,5),this)
        rcl_favorites_foods.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        rcl_favorites_foods.adapter = adapterGhaza
    }

    private fun initCommentRecyclerView(bazKhord: MutableList<BazKhord>){
        adapterComment = CommentAdapter(bazKhord.subList(0,2))
        rcl_last_comments.layoutManager =LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        rcl_last_comments.isNestedScrollingEnabled = false;
        rcl_last_comments.adapter = adapterComment
    }

    private fun initSlider(dayGhaza : List<Ghaza>) {
        val adapterHome = SliderAdapterHome(context, this)
        adapterHome.renewItems(dayGhaza.subList(0,2))
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
        val intent = Intent(context,FoodDetailActivity::class.java)
        intent.putExtra("food",slidesHome)
        startActivity(intent)
    }

    override fun onClickGhaza(ghaza: Ghaza) {
        val intent = Intent(context,FoodDetailActivity::class.java)
        intent.putExtra("food",ghaza)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshHomeFragment()
    }

    override fun onClickNeoGhaza(typeWithList: NoeGhazaWithGhaza) {
        val intent = Intent(context,ListReportActivity::class.java)
        intent.putExtra("extra","type")
        intent.putExtra("typeFoodObject",typeWithList)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = activity!!.menuInflater
        inflater.inflate(R.menu.menu_more_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}