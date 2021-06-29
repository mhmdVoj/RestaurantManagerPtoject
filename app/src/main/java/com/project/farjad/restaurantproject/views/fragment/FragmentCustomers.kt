package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
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
import com.project.farjad.restaurantproject.adapters.MoshtariAdapter
import com.project.farjad.restaurantproject.adapters.ReservesAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Moshtari
import com.project.farjad.restaurantproject.model.Reserve
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.CustomerFragmentViewModel
import com.project.farjad.restaurantproject.views.AddMoshtariActivity
import com.project.farjad.restaurantproject.views.AddReserveActivity
import com.project.farjad.restaurantproject.views.ListReportActivity
import kotlinx.android.synthetic.main.fragment_customer.*

public class FragmentCustomers : Fragment(), MoshtariAdapter.onMoshtariListItemListener {

    val viewModel : CustomerFragmentViewModel by lazy (LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao()))
            .get(CustomerFragmentViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_customer,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.allMoshtari.observe(viewLifecycleOwner, Observer {
            initRecyclerViewMoshtari(it)
            analysis_txt_sum_customer.text = "تعداد مشتریان :  ${it.size}"
        })
        viewModel.allBazkhord.observe(viewLifecycleOwner, Observer {
            analysis_sum_comments.text = "تعداد کل بازخورد ها :  ${it.size}"
        })
        viewModel.allReserves.observe(viewLifecycleOwner, Observer {
            it.forEach { res ->
                res.nameMosh = viewModel.getMoshtariName(res.id)
            }
            initRecyclerViewReserves(it)
            analysis_sum_reserve.text = "تعداد رزرو های امروز : ${it.size}"
        })

        btn_show_list_reserves.setOnClickListener {
            val intent = Intent(context, ListReportActivity::class.java)
            intent.putExtra("extra","reserves")
            startActivity(intent)
        }

        btn_show_list_comments.setOnClickListener {
            val intent = Intent(context, ListReportActivity::class.java)
            intent.putExtra("extra","comment")
            startActivity(intent)
        }

        btn_show_all_customers.setOnClickListener {
            val intent = Intent(context, ListReportActivity::class.java)
            intent.putExtra("extra","customers")
            startActivity(intent)
        }

        btn_show_list_pays.setOnClickListener {
            val intent = Intent(context, ListReportActivity::class.java)
            intent.putExtra("extra","pays")
            startActivity(intent)
        }

        btn_more_customers.setOnClickListener {
            val popupMenu : PopupMenu = PopupMenu(context,btn_more_customers)
            popupMenu.menuInflater.inflate(R.menu.menu_more_customers,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_new_customer->{ startActivity(Intent(context, AddMoshtariActivity::class.java))  }
                    R.id.menu_new_reserve ->{ startActivity(Intent(context,AddReserveActivity::class.java))}
                }
                true
            }
            popupMenu.show()
        }
    }

    private fun initRecyclerViewMoshtari(it: MutableList<Moshtari>) {
        val moshtariAdapter = MoshtariAdapter(it.subList(0,3),false,this)
        rcl_customers_in_page.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rcl_customers_in_page.isNestedScrollingEnabled = false
        rcl_customers_in_page.adapter = moshtariAdapter
    }

    private fun initRecyclerViewReserves(reserve: List<Reserve>){
        val reservesAdapter = ReservesAdapter(reserve,
            ReservesAdapter.onReserveItemListener { Log.i("TAG", "initRecyclerViewReserves: ") })
        rcl_today_reserves.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        rcl_today_reserves.isNestedScrollingEnabled =false
        rcl_today_reserves.adapter = reservesAdapter
        if (reservesAdapter.itemCount != 0){
            rcl_today_reserves.visibility = View.VISIBLE
            txt_no_found_today_res.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = activity!!.menuInflater
        inflater.inflate(R.menu.menu_more_customers, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshCustomerFragment()
    }

    override fun onMoshtariClick(moshtari: Moshtari) {
        Log.i("TAG", "onMoshtariClick: ")
    }


}