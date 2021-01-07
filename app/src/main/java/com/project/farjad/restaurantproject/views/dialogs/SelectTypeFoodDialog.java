package com.project.farjad.restaurantproject.views.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.adapters.NoeGhazaAdapter;
import com.project.farjad.restaurantproject.model.NoeGhaza;
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SelectTypeFoodDialog extends BottomSheetDialogFragment {
    private RecyclerView recyclerView;
    private List<NoeGhazaWithGhaza> noeGhazaList;
    private onTypeFoodClickListener listener;
    private NoeGhazaAdapter noeGhazaAdapter;

    public SelectTypeFoodDialog(List<NoeGhazaWithGhaza> noeGhazaList, onTypeFoodClickListener listener) {
        this.noeGhazaList = noeGhazaList;
        this.listener = listener;
    }

    public SelectTypeFoodDialog(List<NoeGhazaWithGhaza> noeGhazaList) {
        this.noeGhazaList = noeGhazaList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dilog_select_type_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        noeGhazaAdapter= new NoeGhazaAdapter(noeGhazaList, typeWithList ->{
            listener.onClick(typeWithList);
            dismiss();
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),5));
        recyclerView.setAdapter(noeGhazaAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.rcl_list_types);
    }

    public interface onTypeFoodClickListener{
        void onClick(NoeGhazaWithGhaza noeGhaza);
    }


}
