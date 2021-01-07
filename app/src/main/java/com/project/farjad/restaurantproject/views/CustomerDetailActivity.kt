package com.project.farjad.restaurantproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.CommentAdapter
import com.project.farjad.restaurantproject.adapters.PaysAdapter
import com.project.farjad.restaurantproject.adapters.ReservesAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.BazKhord
import com.project.farjad.restaurantproject.model.Moshtari
import com.project.farjad.restaurantproject.model.Pardakhtha
import com.project.farjad.restaurantproject.model.Reserve
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.CustomerDetailViewModel
import com.project.farjad.restaurantproject.views.dialogs.EditFoodDialog
import kotlinx.android.synthetic.main.activity_customer_detail.*
import kotlinx.android.synthetic.main.activity_detail.*

class CustomerDetailActivity : AppCompatActivity() {
    lateinit var localMoshtari : Moshtari
    lateinit var adapterBazkhord : CommentAdapter
    lateinit var adapterReserves : ReservesAdapter
    lateinit var adapterPay : PaysAdapter
    lateinit var viewModel : CustomerDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_detail)
        bindDataIntent()

        viewModel = ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao()))
            .get(CustomerDetailViewModel::class.java)

        viewModel.allBazkhords.observe(this, Observer { list ->
            list.forEach {
                if (it.moshtari.id == localMoshtari.id){
                    initCommentsRecyclerView(it.bazKhordList)
                }
            }
        })

        viewModel.allReserve.observe(this, Observer {list->
            list.forEach {
                if (it.moshtari.id == localMoshtari.id){
                    initReservesRecyclerView(it.reserveList)
                }
            }
        })

        viewModel.allPays.observe(this, Observer {
            it.forEach { pay ->
                if (pay.moshtari.id == localMoshtari.id){
                    initPaysRecyclerView(pay.pardakhthaList)
                }
            }
        })

        btn_edit_customer_detail.setOnClickListener {
            val popupMenu = PopupMenu(this,btn_edit_customer_detail)
            popupMenu.menuInflater.inflate(R.menu.menu_edit_more_customer,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.delete_customer_menu->{
                        viewModel.deleteMoshtari(localMoshtari);
                        finish()
                    }
                }
                true
            }
            popupMenu.show()
        }

        btn_back_detail_customer.setOnClickListener {
            onBackPressed()
        }
    }

    private fun bindDataIntent() {
        localMoshtari = intent.getParcelableExtra("customer") as Moshtari
        if (localMoshtari!=null){
            txt_name_customer_detail.text = localMoshtari.name
            txt_shomare_eshterak_detail.text = localMoshtari.shomareEshtrrak
            txt_address_num_customer_detail.text = "${localMoshtari.address} : ${localMoshtari.shomareTel}"
        }
    }

    fun initReservesRecyclerView(reserves : List<Reserve>){
        adapterReserves = ReservesAdapter(reserves,
            ReservesAdapter.onReserveItemListener { Log.i("TAG", "initReservesRecyclerView: ") })
        if(adapterReserves.itemCount != 0)
            txt_no_found_reserve_this_cus.visibility = View.GONE
        rcl_reserves_this_customer.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rcl_reserves_this_customer.adapter =adapterReserves
    }

    fun initPaysRecyclerView(pardakhtha: MutableList<Pardakhtha>){
        adapterPay = PaysAdapter(pardakhtha)
        if (adapterPay.itemCount != 0)
            txt_no_found_pays_this_cus.visibility = View.GONE
        rcl_pays_this_customer.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rcl_pays_this_customer.adapter =adapterPay
    }


    fun initCommentsRecyclerView(bazKhord: List<BazKhord>){
        adapterBazkhord = CommentAdapter(bazKhord)
        if (adapterBazkhord.itemCount != 0)
            txt_no_found_comment_this_cus.visibility = View.GONE
        rcl_comments_this_customer.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rcl_comments_this_customer.adapter =adapterBazkhord
    }
}