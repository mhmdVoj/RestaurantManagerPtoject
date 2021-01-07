package com.project.farjad.restaurantproject.views.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.project.farjad.restaurantproject.R;

public class SelectDayDialog extends BottomSheetDialogFragment {
    private onSelectDayDialogListener listener;

    private RadioButton shanbe_rdb;
    private RadioButton yekshanbe_rdb;
    private RadioButton doshanbe_rdb;
    private RadioButton seshanbe_rdb;
    private RadioButton charshanbe_rdb;
    private RadioButton panjshanbe_rdb;
    private RadioButton jome_rdb;

    public SelectDayDialog(onSelectDayDialogListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_select_day_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        shanbe_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("شنبه");
            dismiss();
        });
        yekshanbe_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("یک\u200Cشنبه");
            dismiss();
        });
        doshanbe_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("دوشنبه");
            dismiss();
        });
        seshanbe_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("سه\u200Cشنبه");
            dismiss();
        });
        charshanbe_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("چهارشنبه");
            dismiss();
        });
        panjshanbe_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("پنج\u200Cشنبه");
            dismiss();
        });
        jome_rdb.setOnCheckedChangeListener((compoundButton, b) -> {
            listener.onDayClicked("جمعه");
            dismiss();
        });
    }

    public void initViews(View itemView){
        shanbe_rdb = itemView.findViewById(R.id.shanbe_rdb);
        yekshanbe_rdb = itemView.findViewById(R.id.yekshanbe_rdb);
        doshanbe_rdb = itemView.findViewById(R.id.doshanbe_rdb);
        seshanbe_rdb = itemView.findViewById(R.id.seshanbe_rdb);
        charshanbe_rdb = itemView.findViewById(R.id.charshanbe_rdb);
        panjshanbe_rdb = itemView.findViewById(R.id.panjshanbe_rdb);
        jome_rdb = itemView.findViewById(R.id.jome_rdb);
    }

    public interface onSelectDayDialogListener{
        void onDayClicked(String str);
    }
}
