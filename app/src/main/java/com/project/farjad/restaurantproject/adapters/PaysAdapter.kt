package com.project.farjad.restaurantproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.model.Pardakhtha

class PaysAdapter(private val payList : MutableList<Pardakhtha>) : RecyclerView.Adapter<PaysAdapter.PaysViewHolder>() {

    private var filterPayList : MutableList<Pardakhtha>
    init {
        filterPayList= payList
    }

    class PaysViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val txt_date_pay : TextView = itemView.findViewById(R.id.txt_date_pay)
        val txt_mablagh_pay : TextView = itemView.findViewById(R.id.txt_mablagh_pay)
        val txt_tarikh_pay : TextView = itemView.findViewById(R.id.txt_tarikh_pay)
        val txt_peygiri_pay : TextView = itemView.findViewById(R.id.txt_peygiri_pay)
        val txt_shomare_factor_pay : TextView = itemView.findViewById(R.id.txt_shomare_factor_pay)
        val txt_noe_pay : TextView = itemView.findViewById(R.id.txt_noe_pay)
        val txt_name_customer_pay : TextView = itemView.findViewById(R.id.txt_name_customer_pay)
        val layout_expended_pays : ViewGroup = itemView.findViewById(R.id.layout_expended_pays)
        val layout_detail_pay : ViewGroup = itemView.findViewById(R.id.layout_detail_pay)

        fun bindPay(pardakhtha: Pardakhtha){
            txt_date_pay.text = "این پرداخت توسط ${pardakhtha.getMoshName()} در تاریخ ${pardakhtha.tarikhPardakht} انجام شده"
            txt_mablagh_pay.text = pardakhtha.mablagePardakht
            txt_tarikh_pay.text = "تاریخ پرداخت : ${pardakhtha.tarikhPardakht}"
            txt_peygiri_pay.text = "شماره پیگیری : ${pardakhtha.shomarePeygiri}"
            txt_shomare_factor_pay.text = "شماره فاکتور : ${pardakhtha.shomareFactor}"
            txt_noe_pay.text = "نوع پرداخت : ${pardakhtha.noePardakht}"
            txt_name_customer_pay.text = "نام مشتری : ${pardakhtha.moshName}"
            if (pardakhtha.moshName == null) {
                txt_date_pay.text =
                    "این پرداخت توسط این مشتری در تاریخ ${pardakhtha.tarikhPardakht} انجام شده"
                txt_name_customer_pay.text = "نام مشتری : این مشتری"
            }
        }
    }

    fun filterFactor(string: String){
        filterPayList = ArrayList()
        payList.forEach {
            if (it.tarikhPardakht == string){
                filterPayList.add(it)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PaysViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.pardakht_item_layout,
    parent,false))

    override fun getItemCount(): Int =filterPayList.size

    override fun onBindViewHolder(holder: PaysViewHolder, position: Int) {
        holder.bindPay(filterPayList[position])
        holder.layout_expended_pays.setOnClickListener {
            if (!filterPayList[position].isExpend){
                holder.layout_detail_pay.visibility = View.VISIBLE
                filterPayList[position].isExpend = true
            }else{
                holder.layout_detail_pay.visibility = View.GONE
                filterPayList[position].isExpend = false
            }
        }
    }

}