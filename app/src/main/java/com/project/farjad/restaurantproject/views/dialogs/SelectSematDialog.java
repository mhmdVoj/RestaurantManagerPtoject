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
import com.project.farjad.restaurantproject.adapters.SematAdapter;
import com.project.farjad.restaurantproject.model.Semat;
import com.project.farjad.restaurantproject.tools.DataFakerGenerator;


import java.util.List;

public class SelectSematDialog extends BottomSheetDialogFragment {
    private RecyclerView recyclerView;
    private List<Semat> sematList;
    private onSematClickListener listener;
    private SematAdapter sematAdapter;

    public SelectSematDialog(List<Semat> sematList, onSematClickListener listener) {
        this.sematList = sematList;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dilog_select_semat_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        sematAdapter = new SematAdapter(sematList, semat -> {
          listener.onClick(semat);
          dismiss();
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),5));
        recyclerView.setAdapter(sematAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.rcl_list_semats);
    }

    public interface onSematClickListener{
        void onClick(Semat semat);
    }


}
