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
import com.project.farjad.restaurantproject.model.NoeGhaza
import com.project.farjad.restaurantproject.tools.DataFakerGenerator
import kotlinx.android.synthetic.main.fragment_filter.*
import kotlin.collections.ArrayList


public class FragmentFilter(private val listener: filterFragmentListener) : Fragment(),
    NoeGhazaFilterAdapter.filterNoeGhazaCheckBoxListener {

    private var isShowLimitNoe: Boolean = false
    private var isShowLimitPrice: Boolean = false
    private var isShowLimitPoint: Boolean = false
    private var valueLimitPrice: Int = 0
    private var valueMaxNomre: Int = 0
    private val list: MutableList<NoeGhaza> = ArrayList()
    lateinit var adapter : NoeGhazaFilterAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bnt_close_filter.setOnClickListener {
            activity?.onBackPressed()
        }

        list_noe_limit_show.setOnClickListener {
            if (isShowLimitNoe) {
                toggle_noe_close_open.setImageResource(R.drawable.ic_dry_clean)
                rcl_noe_foods_limit.visibility = View.GONE
                isShowLimitNoe = false
            } else {
                toggle_noe_close_open.setImageResource(R.drawable.ic_up_arrow)
                rcl_noe_foods_limit.visibility = View.VISIBLE
                isShowLimitNoe = true
            }

        }

        list_price_limit_show.setOnClickListener {
            if (isShowLimitPrice) {
                toggle_price_limit_close_open.setImageResource(R.drawable.ic_dry_clean)
                layout_seek_bar.visibility = View.GONE
                isShowLimitPrice = false
            } else {
                toggle_price_limit_close_open.setImageResource(R.drawable.ic_up_arrow)
                layout_seek_bar.visibility = View.VISIBLE
                isShowLimitPrice = true
            }
        }

        list_nomre_limit_show.setOnClickListener {
            if (isShowLimitPoint) {
                toggle_nomre_limit_close_open.setImageResource(R.drawable.ic_dry_clean)
                layout_seek_bar_nomre.visibility = View.GONE
                isShowLimitPoint = false
            } else {
                toggle_nomre_limit_close_open.setImageResource(R.drawable.ic_up_arrow)
                layout_seek_bar_nomre.visibility = View.VISIBLE
                isShowLimitPoint = true
            }
        }

        btn_remove_all_filter.setOnClickListener {
            listener.onRemoveAllFilters()
            activity?.onBackPressed()
        }

        initNoeGhazasRecyclerView()
        setDataArguments()

        seek_bar_price.addOnChangeListener { slider, value, fromUser ->
            max_price_limit.text = "غذا های کمتر از $value هزار تومان"
            valueLimitPrice = value.toInt()
        }

        seek_bar_nomre.addOnChangeListener { slider, value, fromUser ->
            max_nomre_limit.text = "غذا های بیشتر از $value  امتیاز"
            valueMaxNomre = value.toInt()
        }

        btn_submit_filter.setOnClickListener {
            listener.onSubmitFilter(valueLimitPrice, valueMaxNomre, list)
            activity?.onBackPressed()
        }
    }

    private fun setDataArguments() {
        if (arguments != null) {
            if (arguments!!.getInt("limitPrice") != 0){
                val value = arguments!!.getInt("limitPrice")
                seek_bar_price.value = arguments!!.getInt("limitPrice").toFloat()
                valueLimitPrice = arguments!!.getInt("limitPrice")
                max_price_limit.text = "غذا های کمتر از $value هزار تومان"
                btn_remove_all_filter.visibility = View.VISIBLE
            }
            if (arguments!!.getInt("limitPoint") != 0){
                val value = arguments!!.getInt("limitPoint")
                seek_bar_nomre.value = arguments!!.getInt("limitPoint").toFloat()
                valueMaxNomre = arguments!!.getInt("limitPoint")
                max_nomre_limit.text = "غذا های بیشتر از $value  امتیاز"
                btn_remove_all_filter.visibility = View.VISIBLE
            }
            if (arguments!!.getStringArray("chkList")!!.isNotEmpty()){
                val value = arguments!!.getStringArray("chkList")
                btn_remove_all_filter.visibility = View.VISIBLE
                value?.forEach {
                    adapter.checkFilterItems(it)
                }
                toggle_noe_close_open.setImageResource(R.drawable.ic_up_arrow)
                rcl_noe_foods_limit.visibility = View.VISIBLE
                isShowLimitNoe = true
            }
        }
    }

    private fun initNoeGhazasRecyclerView() {
        adapter = NoeGhazaFilterAdapter(DataFakerGenerator.getNoeGahaza(), this)
        rcl_noe_foods_limit.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rcl_noe_foods_limit.isNestedScrollingEnabled = false
        rcl_noe_foods_limit.adapter = adapter
    }

    interface filterFragmentListener {
        fun onSubmitFilter(limitPrice: Int, limitNomre: Int, noeGhazaHa: List<NoeGhaza>)
        fun onRemoveAllFilters()
    }

    override fun checkedNoeGhaza(noeGhaza: NoeGhaza) {
        list.add(noeGhaza)
    }

    override fun unCheckedNoeGhaza(noeGhaza: NoeGhaza) {
        list.remove(noeGhaza)
    }
}