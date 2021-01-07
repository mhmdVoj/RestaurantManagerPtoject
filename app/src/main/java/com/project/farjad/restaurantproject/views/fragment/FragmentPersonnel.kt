package com.project.farjad.restaurantproject.views.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.project.farjad.restaurantproject.R
import com.project.farjad.restaurantproject.adapters.PersonnelAdapter
import com.project.farjad.restaurantproject.database.AppDatabase
import com.project.farjad.restaurantproject.model.Personel
import com.project.farjad.restaurantproject.tools.MainViewModelFactory
import com.project.farjad.restaurantproject.viewModels.PersonnelViewModel
import com.project.farjad.restaurantproject.views.AddFoodActivity
import com.project.farjad.restaurantproject.views.AddPersonnelActivity
import com.project.farjad.restaurantproject.views.dialogs.DetailPersonnelDialog
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_personnel.*

class FragmentPersonnel : Fragment() {
    lateinit var viewModel: PersonnelViewModel
    var visiSearchBar =false
    lateinit var adapter : PersonnelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personnel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(AppDatabase.getAppDatabase(context).restaurantDao())
        )
            .get(PersonnelViewModel::class.java)

        viewModel.allPersonels.observe(viewLifecycleOwner, Observer {
            it.forEach { personel ->
               personel.semat = viewModel.getSemat(personel.id_semat).name
                personel.imgSemat = viewModel.getSemat(personel.id_semat).imgResource
            }
            initPersonnelRecyclerView(it)
        })

        btn_search_personnel.setOnClickListener {
            if (visiSearchBar){
                edt_search_personnel.visibility = View.GONE
                btn_search_personnel.setImageResource(R.drawable.ic_search)
                visiSearchBar = false
            }else{
                edt_search_personnel.visibility = View.VISIBLE
                btn_search_personnel.setImageResource(R.drawable.ic_baseline_close_24)
                visiSearchBar = true
            }

        }

        edt_search_personnel.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               adapter.searchFilter(p0.toString())
            }

        })

        btn_more_personnel.setOnClickListener {
            val popupMenu : PopupMenu = PopupMenu(context,btn_more_personnel)
            popupMenu.menuInflater.inflate(R.menu.menu_more_personnel,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_new_personnel->{ startActivity(Intent(context,AddPersonnelActivity::class.java))   }
                }
                true
            }
            popupMenu.show()
        }
    }

    fun initPersonnelRecyclerView(list: MutableList<Personel>) {
        adapter = PersonnelAdapter(list,object : PersonnelAdapter.onPersonelItemListener {
            override fun onClicked(personel: Personel) {
                DetailPersonnelDialog(personel,DetailPersonnelDialog.onDetailPersonnelDialogListener {
                    viewModel.deletePersonnel(it)
                }).show(parentFragmentManager,"")
            }

        })
        rcl_personnel_main.layoutManager = GridLayoutManager(context, 3)
        rcl_personnel_main.isNestedScrollingEnabled =false
        rcl_personnel_main.adapter = adapter
    }

}