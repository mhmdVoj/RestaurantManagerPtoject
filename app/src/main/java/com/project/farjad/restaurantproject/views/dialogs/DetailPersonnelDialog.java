package com.project.farjad.restaurantproject.views.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.adapters.SematAdapter;
import com.project.farjad.restaurantproject.model.Personel;
import com.project.farjad.restaurantproject.model.Semat;

import java.util.List;

public class DetailPersonnelDialog extends BottomSheetDialogFragment {
    private TextView txt_name_personnel_detail;
    private TextView txt_semat_detail;
    private ImageView img_semat_detail;
    private TextView txt_address_num_personnel_detail;
    private TextView txt_date_join_personnel;
    private Button btn_delete_personnel;
    private Personel personel;
    private onDetailPersonnelDialogListener listener;

    public DetailPersonnelDialog(Personel personel, onDetailPersonnelDialogListener listener) {
       this.personel =personel;
       this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_detail_personnel_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        txt_name_personnel_detail.setText(personel.getName());
        txt_address_num_personnel_detail.setText(personel.getAddress() + " : " + personel.getShomareTel());
        txt_semat_detail.setText(personel.getSemat());
        img_semat_detail.setImageResource(personel.getImgSemat());
        txt_date_join_personnel.setText("اين پرسنل در تاريخ "+personel.getTarikhVorol()+" به رستوران پيوسته است");

        btn_delete_personnel.setOnClickListener(v->{
            listener.onDelete(personel);
            dismiss();
        });

    }

    private void initViews(View view) {
        txt_name_personnel_detail = view.findViewById(R.id.txt_name_personnel_detail);
        img_semat_detail = view.findViewById(R.id.img_semat_detail);
        txt_semat_detail = view.findViewById(R.id.txt_semat_detail);
        txt_address_num_personnel_detail = view.findViewById(R.id.txt_address_num_personnel_detail);
        btn_delete_personnel = view.findViewById(R.id.btn_delete_personnel);
        txt_date_join_personnel = view.findViewById(R.id.txt_date_join_personnel);
    }

    public interface onDetailPersonnelDialogListener{
        void onDelete(Personel personel);
    }


}
