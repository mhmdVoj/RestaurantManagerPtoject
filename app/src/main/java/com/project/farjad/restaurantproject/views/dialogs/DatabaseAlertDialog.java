package com.project.farjad.restaurantproject.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.project.farjad.restaurantproject.R;

public class DatabaseAlertDialog extends DialogFragment {
    private Button btn_cancel_dialog;
    private String nameFiled;
    private TextView txt_title_dialog;
    private TextView txt_content_dialog;

    public DatabaseAlertDialog(String nameFiled) {
        this.nameFiled = nameFiled;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        View view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_database_error_layot,null,false);
        dialog.setView(view);
        btn_cancel_dialog =view.findViewById(R.id.btn_cancel_dialog);
        txt_title_dialog =view.findViewById(R.id.txt_title_dialog);
        txt_content_dialog =view.findViewById(R.id.txt_content_dialog);
        txt_title_dialog.setText("حذف این "+nameFiled+" ممکن نیست");
        txt_content_dialog.setText("از اطلاعات اين "+nameFiled+" در جایی استفاده کرده اید. لطفا قبل از حذف، داده های مرتبط را بررسی نمایید.");
        btn_cancel_dialog.setOnClickListener(v->{
            dismiss();
        });
        return dialog.create();
    }
}
