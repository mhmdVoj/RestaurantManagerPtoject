package com.project.farjad.restaurantproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Personel
import com.project.farjad.restaurantproject.tools.CalenderGenerator
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.PersonnelViewModel
import com.project.farjad.restaurantproject.views.dialogs.SelectSematDialog
import kotlinx.android.synthetic.main.activity_add_personnel.*

class AddPersonnelActivity : AppCompatActivity() {
    lateinit var viewModel: PersonnelViewModel
    var idSemat  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_personnel)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())
        ).get(PersonnelViewModel::class.java)

        btn_back_new_personnel.setOnClickListener { onBackPressed() }

        btn_select_semat_personnel.setOnClickListener {
            SelectSematDialog(viewModel.allSemats.value,SelectSematDialog.onSematClickListener {
                idSemat = it.id.toInt()
                txt_semat_personnel_selected.text = "سمت پرسنل : ${it.name}"
            }).show(supportFragmentManager,"")
        }

        btn_submit_new_personnel.setOnClickListener {
            if (edt_select_name_personnel.length() != 0 ){
                if (edt_select_tel_personnel.length() != 0){
                    if (edt_select_address_personnel.length() != 0){
                        if (idSemat != 0){
                            savePersonnelDatabase()
                            finish()
                        }else{
                            Toast.makeText(this,"سمت پرسنل را مشخص نکرده اید",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        edt_select_address_personnel.error = "آدرس را وارد کنید"
                    }
                }else{
                    edt_select_tel_personnel.error = "شماره تلفن را مشخص نکرده اید"
                }
            }else{
                edt_select_name_personnel.error = "نام پرسنل را تعیین کنید"
            }
        }
    }

    private fun savePersonnelDatabase() {
        val personnel = Personel()
        personnel.name = edt_select_name_personnel.text.toString()
        personnel.shomareTel = edt_select_tel_personnel.text.toString()
        personnel.address = edt_select_address_personnel.text.toString()
        personnel.id_semat = idSemat.toLong()
        personnel.tarikhVorol = CalenderGenerator.getCurrentShamsidate()
        viewModel.addPersonnel(personnel)
    }
}