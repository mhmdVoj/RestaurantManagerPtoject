package com.project.farjad.restaurantproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.CommentAdapter
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.tools.DataFackerGanerator
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    lateinit var ghaza : Ghaza
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getFoodData()
        btn_back_detail.setOnClickListener { onBackPressed() }
        initCommentRecyclerView()
    }

    private fun getFoodData() {
        val intent = intent
        ghaza = intent.getParcelableExtra("food") as Ghaza
        if(ghaza !=null){
            txt_name_food_detail.text = ghaza.name
            img_food_detail.setActualImageResource(ghaza.imgGhaza)
            txt_price_food_detail.text =ghaza.gheymat
            txt_tozih_detail.text = ghaza.tozih
            if (ghaza.isMojodi)
                txt_isMojood_detail.text = "موجود"
            else txt_isMojood_detail.text = "تمام شده"
        }
    }

    private fun initCommentRecyclerView(){
        val adapter = CommentAdapter(DataFackerGanerator.getComments())
        rcl_comments_food_details.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rcl_comments_food_details.adapter = adapter
    }
}