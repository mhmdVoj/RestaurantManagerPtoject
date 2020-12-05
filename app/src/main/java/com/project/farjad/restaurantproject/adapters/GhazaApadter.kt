package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Ghaza

public class GhazaApadter(private val foods : List<Ghaza>,val listener : onGhazaListListener) : RecyclerView.Adapter<GhazaApadter.GhazaViewHolder>() {


    class GhazaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_food_item : SimpleDraweeView = itemView.findViewById(R.id.img_food_item)
        val txt_name_item : TextView = itemView.findViewById(R.id.txt_name_food_item)
        val txt_price  : TextView =itemView.findViewById(R.id.txt_price_item)
        val rating_food : RatingBar =itemView.findViewById(R.id.rating_food_item)
        fun bindGhaza(ghaza : Ghaza){
            img_food_item.setActualImageResource(ghaza.imgGhaza)
            txt_name_item.text = ghaza.name
            txt_price.text = ghaza.gheymat
            rating_food.rating = ghaza.nomre.toFloat()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GhazaViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.ghaza_item_layout,parent,false))

    override fun getItemCount() = foods.size

    override fun onBindViewHolder(holder: GhazaViewHolder, position: Int) {
        holder.bindGhaza(foods[position])
        holder.itemView.setOnClickListener {
            listener.onClickGhaza(foods[position])
        }
    }

    public interface onGhazaListListener {
        fun onClickGhaza(ghaza: Ghaza)
    }
}