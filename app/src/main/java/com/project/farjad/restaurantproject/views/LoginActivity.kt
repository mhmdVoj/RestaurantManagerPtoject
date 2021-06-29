package com.project.farjad.restaurantproject.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.tools.PrefsSetting
import com.project.farjad.restaurantproject.viewModels.LogInViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

     lateinit var viewModel : LogInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefsSetting = PrefsSetting(this)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())
        ).get(LogInViewModel::class.java)

        viewModel.prg.observe(this, Observer {
            progressBar.visibility = if (it) { View.VISIBLE } else { View.GONE }
        })

        btn_vorod.setOnClickListener {
            if (edt_user_name.text.toString() == "admin"){
                if (edt_pass.text.toString() == "1234"){
                    viewModel.addData()
                    prefsSetting.saveUser(edt_user_name.text.toString(),edt_pass.text.toString())
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    progressBar.visibility = View.GONE
                }else{
                    edt_pass.error = "رمز کاربری صحیح نیست"
                }
            }else{
                edt_user_name.error = "نام کاربری صحیح نیست"
            }
        }
    }
}