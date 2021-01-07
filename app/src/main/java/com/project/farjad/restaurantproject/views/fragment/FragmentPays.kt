package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.FactorAdapter
import com.project.farjad.restaurantproject.adapters.PaysAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Factor
import com.project.farjad.restaurantproject.model.Pardakhtha
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.FinancialFragmentViewModel
import com.project.farjad.restaurantproject.views.AddFactorActivity
import com.project.farjad.restaurantproject.views.ChartActivity
import com.project.farjad.restaurantproject.views.DetailFactorActivity
import com.project.farjad.restaurantproject.views.ListReportActivity
import kotlinx.android.synthetic.main.fragment_pays.*

public class FragmentPays : Fragment(), FactorAdapter.onFactorItemListener {
    lateinit var viewModel: FinancialFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pays, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao())
        ).get(
            FinancialFragmentViewModel::class.java
        )
        viewModel.lastFactors.observe(viewLifecycleOwner, Observer {
            it.forEach { factor ->
                factor.moshName = viewModel.getMoshtariName(factor.idMoshtari)
                factor.rizNum = viewModel.getCountRizFactor(factor.id).toString()
            }
            initLastFactorsRecyclerView(it)
        })
        viewModel.prgFactors.observe(viewLifecycleOwner, Observer {
            prg_last_factors.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.lastPays.observe(viewLifecycleOwner, Observer {
            it.forEach { pardakhtha ->
                pardakhtha.moshName = viewModel.getMoshtariName(pardakhtha.idMoshtari)
            }
            initLastPaysRecyclerView(it)
        })

        viewModel.prgPays.observe(viewLifecycleOwner, Observer {
            prg_last_pays.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        btn_show_list_pays_fin.setOnClickListener {
            val intent = Intent(context, ListReportActivity::class.java)
            intent.putExtra("extra", "pays")
            startActivity(intent)
        }

        //bindChart()
        btn_show_chart.setOnClickListener {
            startActivity(Intent(context,ChartActivity::class.java))
        }

        btn_more_financial.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(context, btn_more_financial)
            popupMenu.menuInflater.inflate(R.menu.menu_more_financial, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_new_factor -> {
                        startActivity(Intent(context, AddFactorActivity::class.java))
                    }
                }
                true
            }
            popupMenu.show()
        }

        btn_show_list_factors.setOnClickListener {
            val intent = Intent(context, ListReportActivity::class.java)
            intent.putExtra("extra", "factors")
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        viewModel.loadFactors()
        viewModel.loadPays()
    }

    private fun initLastFactorsRecyclerView(factorList: MutableList<Factor>) {
        val adapter = FactorAdapter(factorList.subList(0, 1), this)
        rcl_last_factors.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rcl_last_factors.adapter = adapter
        if (adapter.itemCount != 0) {
            txt_no_found_last_factor.visibility = View.GONE
        }
    }

    private fun initLastPaysRecyclerView(payList: MutableList<Pardakhtha>) {
        val adapter = PaysAdapter(if (payList.size >=2) { payList.subList(0,2) } else { payList.subList(0,1) })
        rcl_last_pays.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rcl_last_pays.adapter = adapter
        if (adapter.itemCount != 0) {
            txt_no_found_last_pay.visibility = View.GONE
        }
    }

    override fun onClickPay(factor: Factor) {

    }

    override fun onClickDetails(factor: Factor) {
        val intent = Intent(context, DetailFactorActivity::class.java)
        intent.putExtra("dataFactor", factor)
        startActivity(intent)
    }
}