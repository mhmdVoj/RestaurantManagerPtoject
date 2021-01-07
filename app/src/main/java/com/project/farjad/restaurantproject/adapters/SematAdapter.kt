package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Semat

public class SematAdapter(private val list : List<Semat> ,private val listener : onSematItemListener) : RecyclerView.Adapter<SematAdapter.SematViewHolder>() {

    class SematViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val img_semat : ImageView = itemView.findViewById(R.id.img_semat)
        val txt_semat : TextView = itemView.findViewById(R.id.txt_semat)

        fun bindSemat(semat: Semat){
            txt_semat.text = semat.name
            img_semat.setImageResource(semat.imgResource)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SematViewHolder {
        return SematViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.semat_item_layout,parent,false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SematViewHolder, position: Int) {
        holder.bindSemat(list[position])
        holder.itemView.setOnClickListener {
            listener.onClicked(list[position])
        }
    }

    interface onSematItemListener{
        fun onClicked(semat: Semat)
    }
}