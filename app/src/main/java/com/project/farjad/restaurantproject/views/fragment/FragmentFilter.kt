package com.project.farjad.restaurantproject.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.NoeGhazaFilterAdapter
import com.project.farjad.restaurantproject.tools.DataFackerGanerator
import kotlinx.android.synthetic.main.fragment_filter.*

public class FragmentFilter : Fragment() {

    private var isShowLimitNoe : Boolean = false
    private var isShowLimitPrice : Boolean = false
    private var isShowLimitPoint : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bnt_close_filter.setOnClickListener {
            activity?.onBackPressed()
        }
        list_noe_limit_show.setOnClickListener {
            if (isShowLimitNoe){
                toggle_noe_close_open.setImageResource(R.drawable.ic_dry_clean)
                rcl_noe_foods_limit.visibility = View.GONE
                isShowLimitNoe = false
            }else {
                toggle_noe_close_open.setImageResource(R.drawable.ic_up_arrow)
                rcl_noe_foods_limit.visibility = View.VISIBLE
                isShowLimitNoe = true
            }

        }
        list_price_limit_show.setOnClickListener {
            if (isShowLimitPrice){
                toggle_price_limit_close_open.setImageResource(R.drawable.ic_dry_clean)
                layout_seek_bar.visibility = View.GONE
                isShowLimitPrice = false
            }else {
                toggle_price_limit_close_open.setImageResource(R.drawable.ic_up_arrow)
                layout_seek_bar.visibility = View.VISIBLE
                isShowLimitPrice = true
            }
        }
        list_nomre_limit_show.setOnClickListener {
            if (isShowLimitPoint){
                toggle_nomre_limit_close_open.setImageResource(R.drawable.ic_dry_clean)
                layout_seek_bar_nomre.visibility = View.GONE
                isShowLimitPoint = false
            }else {
                toggle_nomre_limit_close_open.setImageResource(R.drawable.ic_up_arrow)
                layout_seek_bar_nomre.visibility = View.VISIBLE
                isShowLimitPoint = true
            }
        }
        initNoeGhazasRecyclerView()

        seek_bar_price.addOnChangeListener { slider, value, fromUser ->
            max_price_limit.text = "غذا های کمتر از $value هزار تومان"
        }
        seek_bar_nomre.addOnChangeListener { slider, value, fromUser ->
            max_nomre_limit.text = "غذا های بیشتر از $value  امتیاز"
        }
    }

    private fun initNoeGhazasRecyclerView() {
        val adapter = NoeGhazaFilterAdapter(DataFackerGanerator.getNoeGahaza())
        rcl_noe_foods_limit.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        rcl_noe_foods_limit.isNestedScrollingEnabled =false
        rcl_noe_foods_limit.adapter =adapter
    }
}