package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.NoeGhaza

public class NoeGhazaAdapter(val foodTypes : List<NoeGhaza>,val listener : onNoeGhazaListListener) : RecyclerView.Adapter<NoeGhazaAdapter.NoeGhazaViewHolder>() {
    class NoeGhazaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNoe : TextView = itemView.findViewById(R.id.txt_noe)
        val imgNoe : ImageView = itemView.findViewById(R.id.img_noe)
        fun bindData(noeGhaza: NoeGhaza) {
            txtNoe.text = noeGhaza.name
            imgNoe.setImageResource(noeGhaza.imgResource)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoeGhazaViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.noe_ghaza_item_layout,parent,false))

    override fun getItemCount() =  foodTypes.size

    override fun onBindViewHolder(holder: NoeGhazaViewHolder, position: Int) {
        holder.bindData(foodTypes[position])
        holder.itemView.setOnClickListener {
            listener.onClickNeoGhaza(foodTypes[position])
        }
    }

    interface onNoeGhazaListListener{
        fun onClickNeoGhaza(type : NoeGhaza)
    }


}