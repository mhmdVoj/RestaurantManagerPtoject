package com.project.farjad.restaurantproject.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.views.fragment.FragmentCustomers
import com.project.farjad.restaurantproject.views.fragment.FragmentHome
import com.project.farjad.restaurantproject.views.fragment.FragmentPays
import com.project.farjad.restaurantproject.views.fragment.FragmentSearch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.container_main,
            FragmentHome()
        )
        transaction.commit()
        navigation_main.setNavigationChangeListener { view, position ->
            when(view.id){
                R.id.item_home -> {
                    val transactionHome : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transactionHome.replace(
                        R.id.container_main,
                        FragmentHome()
                    )
                    transactionHome.commit()
                }
                R.id.item_search ->{
                    val transactionSearch : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transactionSearch.replace(
                        R.id.container_main,
                        FragmentSearch()
                    )
                    transactionSearch.commit()
                }
                R.id.item_customers ->{
                    val transactionCustomers : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transactionCustomers.replace(
                        R.id.container_main,
                        FragmentCustomers()
                    )
                    transactionCustomers.commit()
                }
                R.id.item_pays ->{
                    val transactionPays : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transactionPays.replace(
                        R.id.container_main,
                        FragmentPays()
                    )
                    transactionPays.commit()
                }
            }
        }
        navigation_main.setCurrentActiveItem(0)
    }
}