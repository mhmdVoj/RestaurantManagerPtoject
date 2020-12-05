package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.GhazaApadter
import com.project.farjad.restaurantproject.model.Ghaza
import com.project.farjad.restaurantproject.tools.DataFackerGanerator
import com.project.farjad.restaurantproject.views.DetailActivity
import kotlinx.android.synthetic.main.fragment_saerch.*

public class FragmentSearch : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saerch,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_filter.setOnClickListener {
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.container_search,FragmentFilter(),"childFragment")
            transaction.addToBackStack("childFragment")
            transaction.commit()
        }
        //initRecyclerView()
    }

    private fun initRecyclerView(){
        val adapter = GhazaApadter(DataFackerGanerator.getGhaza(),object : GhazaApadter.onGhazaListListener {
            override fun onClickGhaza(ghaza: Ghaza) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("food",ghaza)
                startActivity(intent)
            }
        })

        rcl_search.layoutManager = GridLayoutManager(context,2)
        rcl_search.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        activity?.supportFragmentManager?.popBackStack("childFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}