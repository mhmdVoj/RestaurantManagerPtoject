package com.project.farjad.restaurantproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.model.NoeGhaza

public class GhazaApadter(
    private val foods: MutableList<Ghaza>,
    private val listener: onGhazaListListener
) :
    RecyclerView.Adapter<GhazaApadter.GhazaViewHolder>() {
    var filterFood: MutableList<Ghaza>
    init {
        this.filterFood = foods
    }

    class GhazaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_food_item: SimpleDraweeView = itemView.findViewById(R.id.img_food_item)
        val txt_name_item: TextView = itemView.findViewById(R.id.txt_name_food_item)
        val txt_price: TextView = itemView.findViewById(R.id.txt_price_item)
        val rating_food: RatingBar = itemView.findViewById(R.id.rating_food_item)
        fun bindGhaza(ghaza: Ghaza) {
            img_food_item.setImageURI(ghaza.imgGhaza)
            txt_name_item.text = ghaza.name
            txt_price.text = "${ghaza.gheymat} تومان "
            rating_food.rating = ghaza.nomre.toFloat()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GhazaViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.ghaza_item_layout, parent, false
        )
    )

    override fun getItemCount() = filterFood.size

    override fun onBindViewHolder(holder: GhazaViewHolder, position: Int) {
        holder.bindGhaza(filterFood[position])
        holder.itemView.setOnClickListener {
            listener.onClickGhaza(filterFood[position])
        }
    }

    fun searchFoodsNew(
        text: String,
        limitPrice: Int,
        limitPoint: Int,
        neoGhaza: MutableList<String>
    ) {
        filterFood = ArrayList<Ghaza>()
        if (limitPoint == 0 && limitPrice == 0 && neoGhaza.isEmpty()) {
            if (text == "") {
                filterFood = foods
            } else {
                foods.forEach {
                    if (it.name.toLowerCase().contains(text.toLowerCase())) {
                        filterFood.add(it)
                    }
                }
            }
        } else {
            if (limitPrice != 0) {
                foods.forEach {
                    if (it.gheymat.toInt() <= limitPrice) {
                        if (!filterFood.contains(it)) {
                            filterFood.add(it)
                        }
                    }
                    if (limitPoint != 0) {
                        if (!(it.nomre >= limitPoint)) {
                            filterFood.remove(it)
                        }
                    }
                    if (neoGhaza.isNotEmpty()) {
                        neoGhaza.forEach { noe ->
                            if (noe != it.type)
                                filterFood.remove(it)
                        }
                    }
                }
            }
            if (limitPoint != 0) {
                foods.forEach {
                    if (it.nomre >= limitPoint) {
                        if (!filterFood.contains(it)) {
                            filterFood.add(it)
                        }
                    }
                    if (limitPrice != 0) {
                        if (!(it.gheymat.toInt() <= limitPrice)) {
                            filterFood.remove(it)
                        }
                    }
                    if (neoGhaza.isNotEmpty()) {
                        neoGhaza.forEach { noe ->
                            if (noe != it.type)
                                filterFood.remove(it)
                        }
                    }
                }
            }
            if (neoGhaza.isNotEmpty()) {
                foods.forEach {
                    neoGhaza.forEach { noe ->
                        if (noe == it.type) {
                            if (!filterFood.contains(it))
                                filterFood.add(it)
                        }
                    }
                    if (limitPrice != 0) {
                        if (!(it.gheymat.toInt() <= limitPrice)) {
                            filterFood.remove(it)
                        }
                    }
                    if (limitPoint != 0) {
                        if (!(it.nomre >= limitPoint)) {
                            filterFood.remove(it)
                        }
                    }
                }
            }
        }
        if (text != "") {
            foods.forEach {
                if (!it.name.toLowerCase().contains(text.toLowerCase())) {
                    filterFood.remove(it)
                }
            }
        }
        notifyDataSetChanged()
    }

    fun searchFoodsNew(text: String) {
        filterFood = ArrayList<Ghaza>()
            if (text == "") {
                filterFood = foods
            } else {
                foods.forEach {
                    if (it.name.toLowerCase().contains(text.toLowerCase())) {
                        filterFood.add(it)
                    }
                }
        }
        notifyDataSetChanged()
    }

    interface onGhazaListListener {
        fun onClickGhaza(ghaza: Ghaza)
    }
}