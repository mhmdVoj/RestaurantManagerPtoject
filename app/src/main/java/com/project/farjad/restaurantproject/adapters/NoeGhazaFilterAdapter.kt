package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.NoeGhaza

class NoeGhazaFilterAdapter(private val list : List<NoeGhaza>) :
    RecyclerView.Adapter<NoeGhazaFilterAdapter.NoeGhazaFilterViewHolder>() {

    class NoeGhazaFilterViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val chk_noe_item : CheckBox = view.findViewById(R.id.chk_noe_item)
        fun bindData(item : NoeGhaza){
            chk_noe_item.text = item.name

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoeGhazaFilterViewHolder {
        return NoeGhazaFilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.noe_ghaza_limit_item_layout,parent,false))
    }

    override fun getItemCount()= list.size


    override fun onBindViewHolder(holder: NoeGhazaFilterViewHolder, position: Int) {
       holder.bindData(list[position])
    }
}