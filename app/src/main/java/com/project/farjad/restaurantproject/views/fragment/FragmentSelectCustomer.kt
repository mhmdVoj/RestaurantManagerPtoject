package com.project.farjad.restaurantproject.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.CommentAdapter
import com.project.farjad.restaurantproject.adapters.MoshtariAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Moshtari
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.MoshtariChangeViewModel
import kotlinx.android.synthetic.main.fragment_select_cus_layout.*

class FragmentSelectCustomer(private val callBack : onSelectCustomerListOnListener) : Fragment(), MoshtariAdapter.onMoshtariListItemListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_cus_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao()))
            .get(MoshtariChangeViewModel::class.java)
        viewModel.allMoshtri.observe(viewLifecycleOwner, Observer {
            initRecyclerView(it)
        })

    }

    private fun initRecyclerView(list : MutableList<Moshtari>) {
        val adapter = MoshtariAdapter(list,true,this)
        rcl_customers_select.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        rcl_customers_select.adapter = adapter
    }

    override fun onMoshtariClick(moshtari: Moshtari) {
        callBack.onClick(moshtari)
        activity?.onBackPressed()
    }


    interface onSelectCustomerListOnListener{
        fun onClick(moshtari: Moshtari)
    }


}