package com.project.farjad.restaurantproject.views

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.NoeGhaza
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.FoodChangeViewModel
import com.project.farjad.restaurantproject.viewModels.HomeViewModel
import com.project.farjad.restaurantproject.views.dialogs.SelectTypeFoodDialog
import kotlinx.android.synthetic.main.activity_add_food.*
import java.io.FileNotFoundException

class AddFoodActivity : AppCompatActivity(), SelectTypeFoodDialog.onTypeFoodClickListener {

    lateinit var imageView: ImageView
    private var nameFood: String = ""
    private var geymatFood: String = ""
    private var imgFood = "https://www.izorzok.hu/wp-content/uploads/2020/01/placeholder.png"
    private var tozihFood: String = ""
    private var noeGhaza: NoeGhaza? = null
    lateinit var viewModel: FoodChangeViewModel
    private var mojodiFood = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        imageView = findViewById(R.id.img_pic_new_food)



        viewModel =ViewModelProvider(
                this,
        MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())
        ).get(FoodChangeViewModel::class.java)

        switch_select_new_food.setOnCheckedChangeListener { _, p1 -> mojodiFood = p1 }

        btn_submit_pic_food.setOnClickListener {
            if (edt_url_new_food.length() != 0) {
                img_pic_new_food.setImageURI(edt_url_new_food.text.toString())
                imgFood = edt_url_new_food.text.toString()
            }

        }

        btn_back_new_food.setOnClickListener { onBackPressed() }

        btn_select_type_food.setOnClickListener {
            SelectTypeFoodDialog(viewModel.allNoeGhaza.value, this)
                .show(supportFragmentManager, "tag")
        }

        btn_submit_food.setOnClickListener {
            checkFoodValidation()
        }
    }

    private fun checkFoodValidation() {
        if (edt_select_name_food.text.toString() != "") {
            if (edt_select_price_food.text.toString() != "") {
                if (edt_select_tozih_food.toString() != "") {
                    if (noeGhaza != null) {
                        nameFood = edt_select_name_food.text.toString()
                        geymatFood = edt_select_price_food.text.toString()
                        tozihFood = edt_select_tozih_food.text.toString()
                        submitFood(nameFood, geymatFood, tozihFood, noeGhaza as NoeGhaza, imgFood)
                    } else {
                        Toast.makeText(this, "نوع غذا را تعیین نکرده اید", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    edt_select_tozih_food.error = "توضیحات غذا را کامل کنید"
                }
            } else {
                edt_select_price_food.error = "لطفا قیمت را مشخص کیند"
            }
        } else {
            edt_select_name_food.error = "لطفا نام غذا را وارد نمایید"
        }
    }

    private fun submitFood(nameFood: String, geymatFood: String, tozihFood: String, noeGhaza: NoeGhaza, imgFood: String) {
        val ghaza = Ghaza().apply {
            name = nameFood
            gheymat = geymatFood
            tozih = tozihFood
            id_noeGhaza = noeGhaza.id
            imgGhaza = imgFood
            isMojodi = mojodiFood
            type = noeGhaza.name
        }
        viewModel.addFood(ghaza)
        finish()
    }

    override fun onClick(noeGhaza: NoeGhazaWithGhaza?) {
        this.noeGhaza = noeGhaza?.noeGhaza
        txt_type_food_selected.text = "نوع غذا : ${noeGhaza?.noeGhaza?.name}"
    }
}