package com.project.farjad.restaurantproject.views.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.GhazaApadter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.FoodChangeViewModel
import kotlinx.android.synthetic.main.fragment_select_food_layout.*
import kotlinx.android.synthetic.main.fragment_select_food_layout.view.*

class FragmentSelectFood(private val callBack : onSelcetionFoodListener) : Fragment() {
    lateinit var viewModel : FoodChangeViewModel
    lateinit var adapter : GhazaApadter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_food_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao())).get(FoodChangeViewModel::class.java)


        viewModel.allFoods.observe(viewLifecycleOwner, Observer {foods->
            foods.forEach {
                it.type = viewModel.getTypeGhaza(it.id_noeGhaza)
            }
            initRecyclerView(foods,view)
        })

        edt_search_riz.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapter.searchFoodsNew(p0.toString())
            }

        })


    }

    interface onSelcetionFoodListener{
        fun onFoodReceived(ghaza: Ghaza)
    }

    fun initRecyclerView(foods : MutableList<Ghaza>,itemView : View){
        adapter = GhazaApadter(foods,object : GhazaApadter.onGhazaListListener {
            override fun onClickGhaza(ghaza: Ghaza) {
                callBack.onFoodReceived(ghaza)
                activity?.onBackPressed()
            }
        })
        itemView.rcl_food_selects.layoutManager =GridLayoutManager(context,2)
        itemView.rcl_food_selects.adapter = adapter
    }
}