package com.project.farjad.restaurantproject.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.RizFactorAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Factor
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.Pardakhtha
import com.project.farjad.restaurantproject.model.RizFactor
import com.project.farjad.restaurantproject.tools.CalenderGenerator
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.FactorChangeViewModel
import com.project.farjad.restaurantproject.views.fragment.FragmentSelectFood
import kotlinx.android.synthetic.main.activity_detail_factor.*

class DetailFactorActivity : AppCompatActivity() {
    lateinit var localFactor: Factor
    lateinit var localRizFactor: List<RizFactor>
    lateinit var viewModel: FactorChangeViewModel
    var allPrice: Int = 0
    lateinit var adapter: RizFactorAdapter
    var rizIsEmpty = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_factor)


        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())
        ).get(
            FactorChangeViewModel::class.java
        )

        viewModel.factorRizFactors.observe(this, Observer {
            it.forEach { factorWithRizFactor ->
                if (factorWithRizFactor.factor.id == localFactor.id) {
                    if (factorWithRizFactor.rizFactorList.size > 0) {
                        factorWithRizFactor.rizFactorList.forEach { rizFactor ->
                            rizFactor.ghazaName = viewModel.getGhaza(rizFactor.idGhaza).name
                            rizFactor.geymatGhaza =
                                viewModel.getGhaza(rizFactor.idGhaza).gheymat.toInt()
                            rizFactor.urlImgGhaza = viewModel.getGhaza(rizFactor.idGhaza).imgGhaza
                            rizFactor.noeGhaza = viewModel.getGhaza(rizFactor.idGhaza).type
                            rizFactor.isFactorIsPar = (localFactor.isPardakhtShode)
                        }
                        initRizFactorRecyclerView(factorWithRizFactor.rizFactorList)
                        localRizFactor = factorWithRizFactor.rizFactorList
                        rizIsEmpty = false
                    }
                }
            }
        })

        bindFactorData()

        btn_back_detail_factor.setOnClickListener { onBackPressed() }

        btn_add_riz.setOnClickListener {
            val transaction =
                supportFragmentManager.beginTransaction()
            transaction.add(
                R.id.container_detail_factor,
                FragmentSelectFood(object : FragmentSelectFood.onSelcetionFoodListener {
                    override fun onFoodReceived(ghaza: Ghaza) {
                        if (ghaza.isMojodi) {
                            val rizFactor = RizFactor()
                            rizFactor.idFactor = localFactor.id
                            rizFactor.idGhaza = ghaza.id
                            rizFactor.tedad = 1
                            rizFactor.jameFactor = ghaza.gheymat.toInt()
                            viewModel.addRizFactor(rizFactor)
                            refreshFactor(ghaza.gheymat.toInt())
                        } else {
                            Toast.makeText(
                                this@DetailFactorActivity,
                                "متاسفیم، موجودی این غذا تمام شده",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            )
            transaction.addToBackStack("null")
            transaction.commit()
        }

        btn_delete_factor.setOnClickListener {
            if (!rizIsEmpty) {
                localRizFactor.forEach {
                    viewModel.deleteRiz(it)
                }
            }
            viewModel.deleteFactor(localFactor)
            finish()
        }

        btn_pay_factor_detail.setOnClickListener {
            if (localFactor.jameKol == 0) {
                Toast.makeText(this, "مبلغ این فاکتور صفر است", Toast.LENGTH_LONG).show()
            } else {
                localFactor.isPardakhtShode = true
                viewModel.updateFactor(localFactor)
                payTheFactor(localFactor)
                txt_pay_factor_detail.visibility = View.VISIBLE
                btn_pay_factor_detail.visibility = View.GONE
                btn_add_riz.visibility = View.GONE
                viewModel.loadRizFactors()
            }
        }
    }

    private fun bindFactorData() {
        localFactor = intent.getParcelableExtra("dataFactor") as Factor
        txt_number_fac_detail.text = "شماره فاکتور ${localFactor.shomareFactor}"
        txt_mosh_name_detail_fac.text = localFactor.moshName
        txt_date_fac_detail.text = localFactor.tarikh
        txt_jamel_factor_detail.text = "جمع فاکتور : ${localFactor.jameKol} تومان"
        if (localFactor.isPardakhtShode) {
            txt_pay_factor_detail.visibility = View.VISIBLE
            btn_pay_factor_detail.visibility = View.GONE
            btn_add_riz.visibility = View.GONE
        }
        allPrice = localFactor.jameKol
    }

    private fun payTheFactor(factor: Factor) {
        val pardakhtha = Pardakhtha()
        pardakhtha.noePardakht = "نقدی"
        pardakhtha.isExpend = false
        pardakhtha.shomareFactor = factor.shomareFactor.toString()
        pardakhtha.mablagePardakht = factor.jameKol.toString()
        pardakhtha.shomarePeygiri = (factor.shomareFactor + 1000).toString()
        pardakhtha.tarikhPardakht = CalenderGenerator.getCurrentShamsidate()
        pardakhtha.idMoshtari = factor.idMoshtari
        viewModel.addPay(pardakhtha)
    }

    private fun initRizFactorRecyclerView(list: MutableList<RizFactor>) {
        adapter = RizFactorAdapter(list, object : RizFactorAdapter.onRizFactorItemListener {
            override fun onUpdate(rizFactor: RizFactor, state: String) {
                if (state == "plus") {
                    rizFactor.tedad++
                    rizFactor.jameFactor = rizFactor.jameFactor + rizFactor.geymatGhaza
                    viewModel.updateRizFactor(rizFactor)
                    adapter.updateRiz(rizFactor)
                    refreshFactor(rizFactor.geymatGhaza)
                } else {
                    if (rizFactor.tedad == 1) {
                        viewModel.deleteRiz(rizFactor)
                        refreshFactor(-rizFactor.jameFactor)
                        adapter.removeRiz(rizFactor)
                    } else {
                        rizFactor.tedad--
                        rizFactor.jameFactor = rizFactor.jameFactor - rizFactor.geymatGhaza
                        viewModel.updateRizFactor(rizFactor)
                        adapter.updateRiz(rizFactor)
                        refreshFactor(-(rizFactor.jameFactor))
                    }
                }
            }
        })
        rcl_riz_detail_fac.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcl_riz_detail_fac.adapter = adapter
        if (adapter.itemCount != 0) {
            txt_no_found_riz.visibility = View.GONE
        }
    }

    private fun refreshFactor(newRizPrice: Int) {
        allPrice += newRizPrice
        localFactor.jameKol = allPrice
        viewModel.updateFactor(localFactor)
        viewModel.loadRizFactors()
        txt_jamel_factor_detail.text = "جمع فاكتور :$allPrice تومان "
    }


}