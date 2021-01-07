package com.project.farjad.restaurantproject.views.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.model.Ghaza;

public class EditFoodDialog extends BottomSheetDialogFragment {
    private EditText edt_price_edit;
    private SwitchMaterial switchMaterial;
    private MaterialButton btn_save_changes;
    private Ghaza ghaza;
    private onEditFoodListener listener;


    public EditFoodDialog(Ghaza ghaza, onEditFoodListener listener) {
        this.ghaza = ghaza;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_food_dialog_layot,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        switchMaterial.setOnCheckedChangeListener((compoundButton, b) -> ghaza.setMojodi(b));

        btn_save_changes.setOnClickListener(view1 -> {
            ghaza.setGheymat(edt_price_edit.getText().toString());
            listener.onUpdateFood(ghaza);
            dismiss();
        });
    }

    private void initViews(View itemViews) {
        edt_price_edit = itemViews.findViewById(R.id.edt_price_edit);
        switchMaterial = itemViews.findViewById(R.id.switch_select_edit_food);
        btn_save_changes = itemViews.findViewById(R.id.btn_save_changes);
        edt_price_edit.setText(ghaza.getGheymat());
        switchMaterial.setChecked(ghaza.isMojodi());
    }

    public interface onEditFoodListener{
        void onUpdateFood(Ghaza ghaza);
    }
}
