package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.Moshtari
import com.project.farjad.restaurantproject.views.fragment.FragmentCustomers

class MoshtariAdapter(
    private val moshtariList: MutableList<Moshtari>,
    private val clickable: Boolean,
    private val listener: onMoshtariListItemListener
) : RecyclerView.Adapter<MoshtariAdapter.MoshtariViewHolder>() {

    var filterMoshtariList : MutableList<Moshtari>
    init {
        this.filterMoshtariList = moshtariList
    }


    class MoshtariViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_name_moshtari_list: TextView = itemView.findViewById(R.id.txt_name_moshtari_list)
        val txt_shomare_eshterak_list: TextView = itemView.findViewById(R.id.txt_shomare_eshterak_list)
        val txt_number_moshtari: TextView = itemView.findViewById(R.id.txt_number_moshtari)

        fun bindMoshtari(moshtari: Moshtari) {
            txt_name_moshtari_list.text = moshtari.name
            txt_number_moshtari.text = moshtari.shomareTel
            txt_shomare_eshterak_list.text = moshtari.shomareEshtrrak
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoshtariViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.customer_item_layout, parent, false
        )
    )

    fun filterCustomers(s : String){
        filterMoshtariList = ArrayList<Moshtari>()
        if (s == "") {
            filterMoshtariList = moshtariList
        } else {
            moshtariList.forEach {
                if (it.name.toLowerCase().contains(s.toLowerCase())) {
                    filterMoshtariList.add(it)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = filterMoshtariList.size

    override fun onBindViewHolder(holder: MoshtariViewHolder, position: Int) {
        holder.bindMoshtari(filterMoshtariList[position])
        holder.itemView.setOnClickListener {
            if (clickable)
                listener.onMoshtariClick(filterMoshtariList[position])
        }
    }

    public interface onMoshtariListItemListener {
        fun onMoshtariClick(moshtari: Moshtari)
    }
}