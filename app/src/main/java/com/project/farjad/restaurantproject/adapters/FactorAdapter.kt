package com.project.farjad.restaurantproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Factor

public class FactorAdapter(private val list : MutableList<Factor>,private val callBack :onFactorItemListener)
    : RecyclerView.Adapter<FactorAdapter.FactorViewHolder>() {
    private var filterList : MutableList<Factor>

    init {
        this.filterList = list
    }

    class FactorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val txt_shomare_factor_item : TextView = itemView.findViewById(R.id.txt_shomare_factor_item)
        val txt_mosh_factor_item : TextView = itemView.findViewById(R.id.txt_mosh_factor_item)
        val txt_date_factor_item : TextView = itemView.findViewById(R.id.txt_date_factor_item)
        val txt_count_foods_factor : TextView = itemView.findViewById(R.id.txt_count_foods_factor)
        val txt_jame_factor_item : TextView = itemView.findViewById(R.id.txt_jame_factor_item)
        val btn_detail_factor : TextView = itemView.findViewById(R.id.btn_detail_factor)
        val btn_go_pay_factor : TextView = itemView.findViewById(R.id.btn_go_pay_factor)

        fun bindFactor(factor: Factor){
            if (factor.isPardakhtShode){
                btn_go_pay_factor.visibility = View.GONE
            }
            txt_shomare_factor_item.text = factor.shomareFactor.toString()
            txt_mosh_factor_item.text = factor.moshName
            txt_date_factor_item.text = "تاریخ ${factor.tarikh}"
            txt_jame_factor_item.text = "${factor.jameKol} تومان"
            txt_count_foods_factor.text = "تعداد غذا : ${factor.rizNum}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FactorViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.factor_item_layout,parent,false))

    override fun getItemCount() = filterList.size

    fun filterFactor(string: String){
        filterList = ArrayList()
        list.forEach {
            Log.i("TAG", "filterFactor:$string ${string.length}")
            Log.i("TAG", "filterFactor:${it.tarikh} ${it.tarikh.length}")
            if (it.tarikh == string){
                filterList.add(it)

            }
        }
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: FactorViewHolder, position: Int) {
        holder.bindFactor(filterList[position])
        holder.btn_detail_factor.setOnClickListener {
            callBack.onClickDetails(filterList[position])
        }
        holder.btn_go_pay_factor.setOnClickListener {
            callBack.onClickPay(filterList[position])
        }
    }

    interface onFactorItemListener{
        fun onClickPay(factor: Factor)
        fun onClickDetails(factor: Factor)
    }
}