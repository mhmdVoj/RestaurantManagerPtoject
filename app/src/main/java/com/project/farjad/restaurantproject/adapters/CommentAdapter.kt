package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.BazKhord

public class CommentAdapter(private val comments : List<BazKhord>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txt_content : TextView = itemView.findViewById(R.id.txt_contnet_comment)
        private val txt_date : TextView = itemView.findViewById(R.id.txt_date_comment)
        fun bindComment(bazKhord: BazKhord){
            txt_content.text = bazKhord.mant
            txt_date.text = bazKhord.tarikh
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.commet_item_layout,parent,false))
    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bindComment(comments[position])
    }
}