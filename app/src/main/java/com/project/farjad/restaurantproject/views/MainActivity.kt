package com.project.farjad.restaurantproject.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.tools.PrefsSetting
import com.project.farjad.restaurantproject.views.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs : PrefsSetting = PrefsSetting(this)
        if (prefs.user == "") {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
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
                R.id.item_personnel ->{
                    val transactionPays : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transactionPays.replace(
                        R.id.container_main,
                        FragmentPersonnel()
                    )
                    transactionPays.commit()
                }
            }
        }
        navigation_main.setCurrentActiveItem(0)
    }
}