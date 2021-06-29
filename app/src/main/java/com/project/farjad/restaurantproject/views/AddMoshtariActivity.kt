package com.project.farjad.restaurantproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Moshtari
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.MoshtariChangeViewModel
import kotlinx.android.synthetic.main.activity_add_moshtari.*
import java.util.*

class AddMoshtariActivity : AppCompatActivity() {

    private val viewModel: MoshtariChangeViewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())
        ).get(MoshtariChangeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_moshtari)

        btn_back_new_moshtari.setOnClickListener {
            onBackPressed()
        }

        btn_submit_new_moshtari.setOnClickListener {
            if (edt_select_fistName_moshtari.text.toString() != "") {
                if (edt_select_lastName_moshtari.text.toString() != "") {
                    if (edt_select_tel_moshtari.text.toString() != "") {
                        if (edt_select_address_moshtari.text.toString() != "") {
                            saveMoshtari()
                            finish()
                        } else {
                            edt_select_address_moshtari.error = "فیلد آدرس الزامی است"
                        }
                    } else {
                        edt_select_tel_moshtari.error = "شماره تلفن را وارد نمایید"
                    }
                } else {
                    edt_select_lastName_moshtari.error = "نام خانوادگی را وارد نمایید"
                }
            } else {
                edt_select_fistName_moshtari.error = "نام مشتری را وارد کنید"
            }
        }
    }

    private fun saveMoshtari() {
        val ran = Random()
        val mosh = Moshtari()
        with(mosh){
            name = "${edt_select_fistName_moshtari.text} ${edt_select_lastName_moshtari.text}"
            shomareTel = edt_select_tel_moshtari.text.toString()
            address = edt_select_address_moshtari.text.toString()
            shomareEshtrrak = (ran.nextInt(1000) + 1).toString()
        }
        viewModel.addMoshtari(mosh)
    }
}