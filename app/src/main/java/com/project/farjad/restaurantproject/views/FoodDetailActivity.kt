package com.project.farjad.restaurantproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.CommentAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.BazKhord
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.classHelpers.GhazaWithBazkhord
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.DetailFoodViewModel
import com.project.farjad.restaurantproject.views.dialogs.EditFoodDialog
import kotlinx.android.synthetic.main.activity_detail.*

class FoodDetailActivity : AppCompatActivity(), EditFoodDialog.onEditFoodListener {
    lateinit var Localghaza: Ghaza
    lateinit var viewModel: DetailFoodViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getFoodData()
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())
        ).get(DetailFoodViewModel::class.java);
        viewModel.ghazaWithBazkhod.observe(this, Observer<List<GhazaWithBazkhord>> { ghaza ->
            for (i in ghaza.indices) {
                Log.i(
                    "TAG",
                    "onCreate: " + ghaza[i].bazKhordList.size + " have " + ghaza[i].ghaza.name + ghaza[i].ghaza.id
                )
                if (ghaza[i].ghaza.id == Localghaza.id) {
                    initCommentRecyclerView(ghaza[i].bazKhordList)
                    //dataStudentLsit = allClasses[i].students
                }
            }
        })
        btn_back_detail.setOnClickListener { onBackPressed() }

        btn_edit_food_detail.setOnClickListener {
            val popupMenu : PopupMenu = PopupMenu(this,btn_edit_food_detail)
            popupMenu.menuInflater.inflate(R.menu.menu_edit_more_food,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.edit_food_menu->{
                        EditFoodDialog(Localghaza, this)
                            .show(supportFragmentManager, "edt")
                    }
                    R.id.delete_food_menu->{
                        deleteFood()
                    }
                }
                true
            }
            popupMenu.show()
        }
    }

    private fun deleteFood() {
        viewModel.deleteFood(Localghaza)
        finish()
    }

    private fun getFoodData() {
        val intent = intent
        Localghaza = intent.getParcelableExtra("food") as Ghaza
        if (Localghaza != null) {
            txt_name_food_detail.text = Localghaza.name
            img_food_detail.setImageURI(Localghaza.imgGhaza)
            txt_type_food_detail.text = Localghaza.type
            txt_price_food_detail.text = "${Localghaza.gheymat} تومان "
            txt_tozih_detail.text = Localghaza.tozih
            rating_food_detail.rating = (Localghaza.nomre).toFloat()
            if (Localghaza.isMojodi)
                txt_isMojood_detail.text = "موجود"
            else txt_isMojood_detail.text = "تمام شده"
        }
    }

    private fun initCommentRecyclerView(comments: List<BazKhord>) {
        comments.forEach {
            val str = viewModel.getMoshtariName(it.id_moshtari)
            it.nameMosh = str
        }
        val adapter = CommentAdapter(comments)
        rcl_comments_food_details.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcl_comments_food_details.adapter = adapter
        txt_count_comment_detail.text = " ${adapter.itemCount} نظر برای این غذا ثبت شده است "
        if (adapter.itemCount == 0) {
            txt_count_comment_detail.text = "نظری برای این غذا ثبت نشده"
            txt_no_found_comment.visibility = View.VISIBLE
            txt_tilte_comment_deatil.visibility = View.INVISIBLE
        } else {
            txt_no_found_comment.visibility = View.GONE
        }
    }


    override fun onUpdateFood(ghaza: Ghaza?) {
        viewModel.updateFood(ghaza)
        txt_price_food_detail.text =  "${ghaza?.gheymat} تومان "
        if (ghaza!!.isMojodi)
            txt_isMojood_detail.text = "موجود"
        else txt_isMojood_detail.text = "تمام شده"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_edit_more_food, menu)
        return super.onCreateOptionsMenu(menu)
    }


}