package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.Personel

public class PersonnelAdapter(private val list : MutableList<Personel>,private val callBack : onPersonelItemListener) : RecyclerView.Adapter<PersonnelAdapter.PersonnelViewHolder>() {

    private var filterList : MutableList<Personel>
    init {
        this.filterList = list
    }


    class PersonnelViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val txt_name_personnel_list : TextView = itemView.findViewById(R.id.txt_name_personnel_list)
        val txt_semat_list : TextView = itemView.findViewById(R.id.txt_semat_list)
        val img_semat_list : ImageView = itemView.findViewById(R.id.img_semat_list)
        fun bindPersonnel(personel: Personel){
            txt_name_personnel_list.text = personel.name
            txt_semat_list.text = personel.semat
            img_semat_list.setImageResource(personel.imgSemat)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonnelViewHolder {
       return PersonnelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.personnel_item_layout,parent,false))
    }

    fun searchFilter(string: String){
        filterList = ArrayList()
        if (string == "") {
            filterList = list
        } else {
            list.forEach {
                if (it.name.toLowerCase().contains(string.toLowerCase())) {
                    filterList.add(it)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = filterList.size

    override fun onBindViewHolder(holder: PersonnelViewHolder, position: Int) {
        holder.bindPersonnel(filterList[position])
        holder.itemView.setOnClickListener {
            callBack.onClicked(filterList[position])
        }
    }

    interface onPersonelItemListener{
        fun onClicked(personel: Personel)
    }
}