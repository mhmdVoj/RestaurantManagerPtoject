package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.BazKhord
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithBazkhord
import kotlinx.android.synthetic.main.commet_item_layout.view.*

public class CommentAdapter(private val comments : List<BazKhord> ) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txt_content : TextView = itemView.findViewById(R.id.txt_contnet_comment)
        private val txt_date : TextView = itemView.findViewById(R.id.txt_date_comment)
        private val rating_bar_comment : RatingBar = itemView.findViewById(R.id.rating_bar_comment)
        private val txt_customer_commented : TextView = itemView.findViewById(R.id.txt_customer_commented)
        fun bindComment(bazKhord: BazKhord){
            txt_content.text = bazKhord.mant
            txt_date.text = "${bazKhord.nameMosh} ${bazKhord.tarikh} برای غذای ${bazKhord.nameGhaz} گذاشته"
            txt_customer_commented.text = bazKhord.nameMosh
            rating_bar_comment.rating = bazKhord.rating.toFloat()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.commet_item_layout,parent,false))
    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bindComment(comments[position])
    }
}