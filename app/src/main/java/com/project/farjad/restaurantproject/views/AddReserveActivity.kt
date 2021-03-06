package com.project.farjad.restaurantproject.views

import android.R.attr.typeface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Moshtari
import com.project.farjad.restaurantproject.model.Reserve
import com.project.farjad.restaurantproject.tools.CalenderGenerator
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.ReserveChangeViewModel
import com.project.farjad.restaurantproject.views.dialogs.TimePickerFragment
import com.project.farjad.restaurantproject.views.fragment.FragmentSelectCustomer
import ir.hamsaa.persiandatepicker.Listener
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog
import ir.hamsaa.persiandatepicker.util.PersianCalendar
import kotlinx.android.synthetic.main.activity_add_reserve.*


class AddReserveActivity : AppCompatActivity(),
    FragmentSelectCustomer.onSelectCustomerListOnListener {

    var dayReserve: String? = null
    var dateReserve: String? = null
    var moshId: Long? = null
    var timeReserve: String? = null
    var timeSabt : String? = null
    var shomareMiz = 0
    var countMihman = 0
    var isVpn = false
    lateinit var viewModel : ReserveChangeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reserve)

        viewModel = ViewModelProvider(this,MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())).get(
            ReserveChangeViewModel::class.java)

        if (isVpn) {
            chk_vpn.isChecked = true
        } else {
            chk_normal.isChecked = true
        }

        chk_vpn.setOnCheckedChangeListener { _, b ->
            isVpn = b
        }

        btn_back_new_reserve.setOnClickListener {
            onBackPressed()
        }

        btn_select_customer_reserve.setOnClickListener {
            goToFragmentSelectCustomer()
        }

        btn_select_date_reserve.setOnClickListener {
            datePickerDialog()
        }

        btn_select_time_reserve.setOnClickListener {
            TimePickerFragment(object : TimePickerFragment.TimePickerFragmentListener {
                override fun onGetTime(time: String) {
                    txt_time_new_reserve.text = "???????? ???????? : $time"
                    timeReserve = time
                }

            }).show(supportFragmentManager, "timePicker")
        }

        btn_submit_reserve.setOnClickListener {
            if (dateReserve != null){
                if (dayReserve != null){
                    if (moshId != null){
                        if (timeReserve != null){
                            if (edt_select_shomare_miz_reserve.length() != 0){
                                if (edt_select_count_reserve.length() != 0){
                                    addReserveDatabase()
                                }else{
                                    edt_select_count_reserve.error = "?????????? ?????????????? ???? ???????? ????????"
                                }
                            }else{
                                edt_select_shomare_miz_reserve.error = "?????????? ???????? ???? ???????? ????????????"
                            }
                        }else{
                            Toast.makeText(this@AddReserveActivity,"???????? ???????? ???????? ????????",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@AddReserveActivity,"?????????? ???? ???????? ?????????? ??????",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this@AddReserveActivity,"?????? ???????? ???? ???????????? ????????????",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@AddReserveActivity,"?????????? ???????? ???????? ????????",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addReserveDatabase() {
        val reserve = Reserve().apply {
            idMoshtari = moshId as Long
            isVip = isVpn
            rozeReserve = dayReserve
            saatReserve =timeReserve
            shomareMiz = edt_select_shomare_miz_reserve.text.toString()
            tarikhReserve = dateReserve
            tarikhSabtReserve = CalenderGenerator.getCurrentShamsidate()
            tedad = edt_select_count_reserve.text.toString()
        }
        viewModel.addReserve(reserve)
        finish()
    }

    private fun datePickerDialog() {
        val picker = PersianDatePickerDialog(this)
            .setPositiveButtonString("????????")
            .setNegativeButton("????????????")
            .setTodayButton("??????????")
            .setTypeFace(ResourcesCompat.getFont(this, R.font.dana_medium))
            .setTodayButtonVisible(true)
            .setMinYear(1300)
            .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
            .setActionTextColor(Color.GRAY)
            .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
            .setShowInBottomSheet(true)
            .setListener(object : Listener {
                override fun onDateSelected(persianCalendar: PersianCalendar) {
                    dayReserve = persianCalendar.persianWeekDayName
                    val str = persianCalendar.persianYear
                        .toString() + "/" + persianCalendar.persianMonth + "/" + persianCalendar.persianDay
                    dateReserve = str
                    Log.i("TAG", "onDateSelected: $dayReserve")
                    txt_date_new_reserve.text =
                        "?????????? ???????? : $str ${persianCalendar.persianWeekDayName}"
                }
                override fun onDismissed() {
                    Toast.makeText(this@AddReserveActivity,"???????????? ???? ???????????? ????????????",Toast.LENGTH_SHORT).show()
                }
            })
        picker.show()
    }

    private fun goToFragmentSelectCustomer() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_new_res, FragmentSelectCustomer(this))
        transaction.addToBackStack("null")
        transaction.commit()
    }

    override fun onClick(moshtari: Moshtari) {
        txt_customer_new_reserve.text = "?????? ?????????? : ${moshtari.name}"
        moshId = moshtari.id
    }
}