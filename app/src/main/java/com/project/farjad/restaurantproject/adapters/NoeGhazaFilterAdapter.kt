package com.project.farjad.restaurantproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.NoeGhaza

class NoeGhazaFilterAdapter(
    private val list: List<NoeGhaza>,
    private val chkListener: filterNoeGhazaCheckBoxListener
) :
    RecyclerView.Adapter<NoeGhazaFilterAdapter.NoeGhazaFilterViewHolder>() {

    class NoeGhazaFilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chk_noe_item: CheckBox = view.findViewById(R.id.chk_noe_item)
        fun bindData(item: NoeGhaza) {
            chk_noe_item.text = item.name
        }
    }

    fun checkFilterItems(str : String){
        list.forEach {
            if (it.name == str){
                it.isChecked =true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoeGhazaFilterViewHolder {
        return NoeGhazaFilterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.noe_ghaza_limit_item_layout, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: NoeGhazaFilterViewHolder, position: Int) {
        holder.bindData(list[position])
        holder.chk_noe_item.setOnCheckedChangeListener { _, p1 ->
            if (p1) {
                chkListener.checkedNoeGhaza(list[position])
            } else {
                chkListener.unCheckedNoeGhaza(list[position])
            }
        }
        holder.chk_noe_item.isChecked = list[position].isChecked
    }

    interface filterNoeGhazaCheckBoxListener {
        fun checkedNoeGhaza(noeGhaza: NoeGhaza)
        fun unCheckedNoeGhaza(noeGhaza: NoeGhaza)
    }
}