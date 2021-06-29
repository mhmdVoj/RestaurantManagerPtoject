package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.FilterLabelAdapter
import com.project.farjad.restaurantproject.adapters.GhazaApadter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.NoeGhaza
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.SearchViewModel
import com.project.farjad.restaurantproject.views.FoodDetailActivity
import kotlinx.android.synthetic.main.fragment_saerch.*
import java.util.ArrayList

public class FragmentSearch : Fragment(), FragmentFilter.filterFragmentListener {

    private var valueLimitPriceSearch: Int = 0
    private var valueMaxNomreSearch: Int = 0
    private val listNoeGhazaSearch: MutableList<String> = ArrayList()
    lateinit var adapterSearch: GhazaApadter
    private var filtersEnable = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saerch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao())).get(SearchViewModel::class.java)
        viewModel.allGhaza.observe(viewLifecycleOwner, Observer {foods->
            foods.forEach {
                it.type = viewModel.getTypeGhaza(it.id_noeGhaza)
            }
            initRecyclerView(foods)
        })
        btn_filter.setOnClickListener {
            val fragmentFilter = FragmentFilter(this)

            val bundle = Bundle()
            bundle.putInt("limitPrice",valueLimitPriceSearch)
            bundle.putInt("limitPoint",valueMaxNomreSearch)
            bundle.putStringArray("chkList",listNoeGhazaSearch.toTypedArray())
            fragmentFilter.arguments = bundle

            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.container_search,fragmentFilter, "childFragment")
            transaction.addToBackStack("childFragment")
            transaction.commit()
        }
        edt_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.i("TAG", "afterTextChanged: ")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("TAG", "afterTextChanged: ")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapterSearch.searchFoodsNew(
                    text = p0.toString(),
                    limitPrice = valueLimitPriceSearch
                    , limitPoint = valueMaxNomreSearch
                    , neoGhaza = listNoeGhazaSearch
                )
                checkEmptyAdapter()
            }
        })


    }

    private fun initRecyclerView(ghazas:  MutableList<Ghaza>) {
        adapterSearch =
            GhazaApadter(ghazas, object : GhazaApadter.onGhazaListListener {
                override fun onClickGhaza(ghaza: Ghaza) {
                    val intent = Intent(context, FoodDetailActivity::class.java)
                    intent.putExtra("food", ghaza)
                    startActivity(intent)
                }
            })
        rcl_search.layoutManager = GridLayoutManager(context, 2)
        rcl_search.adapter = adapterSearch
        checkEmptyAdapter()
    }

    override fun onSubmitFilter(limitPrice: Int, limitNomre: Int, noeGhazaHa: List<NoeGhaza>) {
        listNoeGhazaSearch.clear()
        valueLimitPriceSearch = limitPrice
        valueMaxNomreSearch = limitNomre
        if (noeGhazaHa.isNotEmpty()) {
            noeGhazaHa.forEach {
                listNoeGhazaSearch.add(it.name)
            }
        }
        filtersEnable = true
        rcl_label_filters.visibility = View.VISIBLE
        initFilterLabelsRecyclerView(limitNomre, limitPrice, noeGhazaHa)
        adapterSearch.searchFoodsNew(
            text = "",
            limitPrice = valueLimitPriceSearch
            , limitPoint = valueMaxNomreSearch
            , neoGhaza = listNoeGhazaSearch
        )
        checkEmptyAdapter()
    }

    override fun onRemoveAllFilters() {
        valueLimitPriceSearch = 0
        valueMaxNomreSearch = 0
        listNoeGhazaSearch.clear()
        rcl_label_filters.visibility = View.GONE
        adapterSearch.searchFoodsNew("",0,0,listNoeGhazaSearch)
        checkEmptyAdapter()
    }

    private fun initFilterLabelsRecyclerView(limitNomre: Int, limitPrice: Int, noeGhazaHa: List<NoeGhaza>) {
        val list: MutableList<String> = ArrayList<String>()
        if (limitNomre != 0)
            list.add("فیلتر امتیاز $limitNomre ")
        if (limitPrice != 0)
            list.add("فیلتر قیمت  $limitPrice")
        if (noeGhazaHa.isNotEmpty()){
            noeGhazaHa.forEach {
                list.add("فیلتر نوع غذا ${it.name}")
            }
        }
        val adapter = FilterLabelAdapter(list)
        rcl_label_filters.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rcl_label_filters.adapter = adapter
    }

    fun checkEmptyAdapter(){
        if (adapterSearch.itemCount==0){
            txt_no_found_search.visibility = View.VISIBLE
        }else{
            txt_no_found_search.visibility = View.GONE
        }
    }

    override fun onStop() {
        super.onStop()
        if (activity?.supportFragmentManager?.backStackEntryCount == 1) {
            activity?.supportFragmentManager?.popBackStack(
                "childFragment",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }
}