package com.project.farjad.restaurantproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.database.AppDatabase;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.tools.CalenderGenerator;
import com.project.farjad.restaurantproject.tools.MainViewModelFactory;
import com.project.farjad.restaurantproject.viewModels.FactorChangeViewModel;
import com.project.farjad.restaurantproject.views.fragment.FragmentSelectCustomer;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class AddFactorActivity extends AppCompatActivity {
    private ImageView btn_back_new_factor;
    private CheckBox chk_sale_new_factor;
    private EditText edt_sale_new_factor;
    private MaterialButton btn_select_customer_factor;
    private TextView txt_customer_new_factor;
    private EditText edt_date_new_factor;
    private Button btn_show_list_factors_new;
    private Button btn_submit_factor;
    private Button btn_submit_factor_and_go;
    private FactorChangeViewModel viewModel;

    private String namMosh;
    private long idCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_factor);
        viewModel = new ViewModelProvider(this,new MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())).
                get(FactorChangeViewModel.class);

        initViews();

        edt_date_new_factor.setText(CalenderGenerator.getCurrentShamsidate());

        btn_back_new_factor.setOnClickListener(view->{
            onBackPressed();
        });

        btn_show_list_factors_new.setOnClickListener(v->{
            Intent intent =new  Intent(AddFactorActivity.this, ListReportActivity.class);
            intent.putExtra("extra","factors");
            startActivity(intent);
        });

        btn_select_customer_factor.setOnClickListener(v->{
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container_new_factor,new FragmentSelectCustomer(moshtari -> {
                txt_customer_new_factor.setText("نام مشتری "+ moshtari.getName());
                idCustomer = moshtari.getId();
                namMosh = moshtari.getName();
            }));
            transaction.addToBackStack("null");
            transaction.commit();
        });

        chk_sale_new_factor.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                edt_sale_new_factor.setVisibility(View.VISIBLE);
            }else {
                edt_sale_new_factor.setVisibility(View.GONE);
            }
        });

        btn_submit_factor.setOnClickListener(view -> {
            if (idCustomer != 0){
                if (edt_date_new_factor.length() != 0){
                    addFactorDatabase();
                    finish();
                }else {
                    edt_date_new_factor.setError("تاریخ فاکتور باید مقدار داشته باشد");
                }
            }else {
                Toast.makeText(this, "مشتری را تعیین نکرده اید", Toast.LENGTH_SHORT).show();
            }
        });

        btn_submit_factor_and_go.setOnClickListener(v->{
            if (idCustomer != 0){
                if (edt_date_new_factor.length() != 0){
                    Factor factor = addFactorDatabase();
                    Intent intent =new Intent(this, DetailFactorActivity.class);
                    intent.putExtra("dataFactor", factor);
                    startActivity(intent);
                    finish();
                }else {
                    edt_date_new_factor.setError("تاریخ فاکتور باید مقدار داشته باشد");
                }
            }else {
                Toast.makeText(this, "مشتری را تعیین نکرده اید", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Factor addFactorDatabase() {
        Random random = new Random();
        Factor factor =new Factor();
        factor.setPardakhtShode(false);
        factor.setTarikh(edt_date_new_factor.getText().toString());
        factor.setIdMoshtari(idCustomer);
        factor.setMoshName(namMosh);
        factor.setShomareFactor(idCustomer + 100 + random.nextInt(50));
        if (edt_sale_new_factor.length() != 0)
            factor.setTarikh(edt_sale_new_factor.getText().toString());
        long res = viewModel.addFactor(factor);
        if (res > 0){
            Toast.makeText(this, "موفق", Toast.LENGTH_SHORT).show();
            factor.setId(res);
        }
        return factor;
    }

    private void initViews() {
        btn_back_new_factor = findViewById(R.id.btn_back_new_factor);
        chk_sale_new_factor= findViewById(R.id.chk_sale_new_factor);
        edt_sale_new_factor = findViewById(R.id.edt_sale_new_factor);
        btn_select_customer_factor = findViewById(R.id.btn_select_customer_factor);
        txt_customer_new_factor = findViewById(R.id.txt_customer_new_factor);
        edt_date_new_factor = findViewById(R.id.edt_date_new_factor);
        btn_show_list_factors_new = findViewById(R.id.btn_show_list_factors_new);
        btn_submit_factor = findViewById(R.id.btn_submit_factor);
        btn_submit_factor_and_go = findViewById(R.id.btn_submit_factor_and_go);
    }
}