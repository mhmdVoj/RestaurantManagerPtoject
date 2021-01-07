package com.project.farjad.restaurantproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.RizFactor

public class RizFactorAdapter(private val listRiz : MutableList<RizFactor>,private val callBack : onRizFactorItemListener) : RecyclerView.Adapter<RizFactorAdapter.RizFactorViewHolder>() {

    class RizFactorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img_ghaza_riz : SimpleDraweeView = itemView.findViewById(R.id.img_ghaza_riz)
        val txt_name_ghaza_riz : TextView = itemView.findViewById(R.id.txt_name_ghaza_riz)
        val txt_price_ghaza_riz : TextView = itemView.findViewById(R.id.txt_price_ghaza_riz)
        val txt_tedad_ghaza_riz : TextView = itemView.findViewById(R.id.txt_tedad_ghaza_riz)
        val txt_jame_riz : TextView = itemView.findViewById(R.id.txt_jame_riz)
        val plus_tedad_riz : ImageView = itemView.findViewById(R.id.plus_tedad_riz)
        val minus_tedad_riz : ImageView = itemView.findViewById(R.id.minus_tedad_riz)
        val txt_noe_ghaza_riz : TextView = itemView.findViewById(R.id.txt_noe_ghaza_riz)

        fun bindRiz(rizFactor: RizFactor){
            if (rizFactor.isFactorIsPar){
                plus_tedad_riz.visibility =View.GONE
                minus_tedad_riz.visibility =View.GONE
            }else{
                plus_tedad_riz.visibility =View.VISIBLE
                minus_tedad_riz.visibility =View.VISIBLE
            }
            txt_jame_riz.text = rizFactor.jameFactor.toString()
            txt_tedad_ghaza_riz.text = rizFactor.tedad.toString()
            txt_price_ghaza_riz.text =rizFactor.geymatGhaza.toString()
            img_ghaza_riz.setImageURI(rizFactor.urlImgGhaza)
            txt_name_ghaza_riz.text = rizFactor.ghazaName
            txt_noe_ghaza_riz.text = rizFactor.noeGhaza
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RizFactorViewHolder {
        return RizFactorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.riz_factor_item_layout,parent,false))
    }

    fun removeRiz(rizFactor: RizFactor){
        for (i in listRiz.indices) {
            if (listRiz[i].id == rizFactor.id) {
                listRiz.remove(rizFactor)
                notifyItemRemoved(i)
                break
            }
        }
    }

    fun updateRiz(rizFactor: RizFactor){
        listRiz.forEachIndexed { index, rizFactorList ->
            if (rizFactor.id == rizFactorList.id)
            listRiz[index] = rizFactor
            notifyItemChanged(index)
        }
    }

    override fun getItemCount() = listRiz.size

    override fun onBindViewHolder(holder: RizFactorViewHolder, position: Int) {
        holder.bindRiz(listRiz[position])
        holder.plus_tedad_riz.setOnClickListener {
            callBack.onUpdate(listRiz[position],"plus")
        }
        holder.minus_tedad_riz.setOnClickListener {
            callBack.onUpdate(listRiz[position],"minus")
        }
    }

    interface onRizFactorItemListener{
        fun onUpdate(rizFactor: RizFactor,state : String)
    }
}