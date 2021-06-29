package com.project.farjad.restaurantproject.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.database.RestaurantDao
import com.project.farjad.restaurantproject.model.Pardakhtha
import com.project.farjad.restaurantproject.model.Reserve
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_chart.*
import java.util.*
import kotlin.collections.ArrayList

class ChartActivity : AppCompatActivity() {
    lateinit var restaurantDao : RestaurantDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        btn_back_chart.setOnClickListener { onBackPressed() }

        restaurantDao = AppDatabase.getAppDatabase(this).restaurantDao()
        restaurantDao.pays
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Pardakhtha>> {
                override fun onSuccess(t: List<Pardakhtha>) {
                    if (t.size < 2){
                        txt_no_found_chart.visibility = View.VISIBLE
                        chart_customers_analysis.visibility = View.GONE
                    }else{
                        if(t.size >= 10){
                            bindLineChart(t.subList(0,9))
                        }
                        bindLineChart(t)
                    }
                }
                override fun onSubscribe(d: Disposable) {

                }
                override fun onError(e: Throwable) {
                    Log.i("TAG", "onError: $e")
                }
            })
        restaurantDao.reserves
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Reserve>>{
                override fun onSuccess(t: List<Reserve>) {
                    if (t.isEmpty()){
                        txt_no_found_chart_pie.visibility = View.VISIBLE
                        chart_customers_analysis_pie.visibility = View.GONE
                    }else{
                        bindPieChart(t)
                    }
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                }

            })

    }

    private fun bindLineChart(list: List<Pardakhtha>) {
        val lineChart: LineChart = LineChart(this)
        lineChart.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        chart_customers_analysis.addView(lineChart)
        val entires: MutableList<Entry> = ArrayList()

        //set Data ==

        list.forEachIndexed { index, pardakhtha ->
            entires.add(Entry((index).toFloat(), pardakhtha.mablagePardakht.toFloat()))
        }


        val lineData = LineDataSet(entires, "نمودار فروش (پرداخت)")
        lineData.lineWidth = 4f
        lineChart.animateX(1000)
        lineChart.data = LineData(lineData)
    }

    private fun bindPieChart(list: List<Reserve>){
        val pieChart = PieChart(this)
        pieChart.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        chart_customers_analysis_pie.addView(pieChart)
        val entries : MutableList<PieEntry> =  ArrayList()

        val numValues = 7
        val days: MutableList<String> = java.util.ArrayList()
        days.add("شنبه")
        days.add("یک\u200Cشنبه")
        days.add("دوشنبه")
        days.add("سه\u200Cشنبه")
        days.add("چهارشنبه")
        days.add("پنج\u200Cشنبه")
        days.add("جمعه")
        for (i in 0 until numValues) {
            var count = 0
            for (j in list.indices) {
                if (list[j].rozeReserve==days[i]) {
                    count++
                }
            }
            if (count == 0) continue
            entries.add(PieEntry(count.toFloat(),days[i]))
        }

        val pieDataSet = PieDataSet(entries,"رزور های در هفته")
        val pieData = PieData(pieDataSet)

        pieDataSet.colors = ColorTemplate.JOYFUL_COLORS.toList()
        pieDataSet.setDrawValues(false)
        pieChart.data = pieData
        pieChart.animateXY(1000,1500)
        pieChart.invalidate()
    }



}