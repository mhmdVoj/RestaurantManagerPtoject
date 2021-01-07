package com.project.farjad.restaurantproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.adapters.CommentAdapter;
import com.project.farjad.restaurantproject.adapters.FactorAdapter;
import com.project.farjad.restaurantproject.adapters.GhazaApadter;
import com.project.farjad.restaurantproject.adapters.MoshtariAdapter;
import com.project.farjad.restaurantproject.adapters.PaysAdapter;
import com.project.farjad.restaurantproject.adapters.ReservesAdapter;
import com.project.farjad.restaurantproject.database.AppDatabase;
import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.Pardakhtha;
import com.project.farjad.restaurantproject.model.Reserve;
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza;
import com.project.farjad.restaurantproject.tools.CalenderGenerator;
import com.project.farjad.restaurantproject.tools.MainViewModelFactory;
import com.project.farjad.restaurantproject.viewModels.ReportViewModel;
import com.project.farjad.restaurantproject.views.dialogs.SelectDayDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class ListReportActivity extends AppCompatActivity implements MoshtariAdapter.onMoshtariListItemListener {
    private RecyclerView rcl_reports;
    private ImageView btn_back;
    private CommentAdapter commentAdapter;
    private GhazaApadter ghazaAdapter;
    private MoshtariAdapter moshtariAdapter;
    private ReservesAdapter reservesAdapter;
    private FactorAdapter factorAdapter;
    private PaysAdapter paysAdapter;
    private TextView txt_name_report;
    private TextView txt_no_found_report;
    private ReportViewModel viewModel;
    private ImageView btn_show_search_report;
    private EditText edt_search_report;
    private int typeReport;

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.loadFactors();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        viewModel = new ViewModelProvider(this, new MainViewModelFactory(AppDatabase.getAppDatabase(this).restaurantDao())).get(
                ReportViewModel.class);
        initViews();
        bindViewWithIntent();
        btn_back.setOnClickListener(v -> { onBackPressed(); });

        btn_show_search_report.setOnClickListener(view -> {
            switch (typeReport){
                case 1:

                    break;
                case 2:
                    edt_search_report.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    new SelectDayDialog(str -> reservesAdapter.filterReserve(str)).show(getSupportFragmentManager(),"");
                    checkEmptyListReserve();
                    break;
                case 4:
                    break;
                case 5:
                    datePickerDialog();
                    break;
            }
        });

        edt_search_report.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(ListReportActivity.this,"تاریخ مورد نظر را انتخاب کنید",Toast.LENGTH_SHORT).show();
                moshtariAdapter.filterCustomers(charSequence.toString());
                checkEmptyListCustomer();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void datePickerDialog() {
        PersianDatePickerDialog picker = new PersianDatePickerDialog(this)
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1300)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setActionTextColor(Color.GRAY)
                .setTypeFace(ResourcesCompat.getFont(this, R.font.dana_medium))
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        String str = persianCalendar.getPersianLongDate();
                        factorAdapter.filterFactor(str);
                        checkEmptyListFactor();
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        picker.show();
    }

    private void bindViewWithIntent() {
        String key = getIntent().getStringExtra("extra");
        switch (key) {
            case "comment":
                btn_show_search_report.setVisibility(View.GONE);
                typeReport = 1;
                txt_name_report.setText("بازخورد ها");
                viewModel.getAllBazkhordWithCustomer().observe(this, moshtariWithBazkhords -> {
                    List<BazKhord> allBaz = new ArrayList<>();
                    for (int i = 0; i < moshtariWithBazkhords.size(); i++) {
                        for (int j = 0; j < moshtariWithBazkhords.get(i).bazKhordList.size(); j++) {
                            moshtariWithBazkhords.get(i).bazKhordList.get(j).setNameMosh(moshtariWithBazkhords.get(i).moshtari.getName());
                            moshtariWithBazkhords.get(i).bazKhordList.get(j).setNameGhaz(viewModel.getGhazaName(moshtariWithBazkhords.get(i).bazKhordList.get(j).getId_ghaza()));
                            allBaz.add(moshtariWithBazkhords.get(i).bazKhordList.get(j));
                        }
                    }
                    initRecyclerViewComments(allBaz);
                });
                break;
            case "type":
                btn_show_search_report.setVisibility(View.GONE);
                NoeGhazaWithGhaza noeGhazaWithGhaza = getIntent().getParcelableExtra("typeFoodObject");
                txt_name_report.setText(noeGhazaWithGhaza.noeGhaza.getName());
                initRecyclerViewFoods(noeGhazaWithGhaza.ghazaList);
                break;
            case "customers":
                typeReport = 2;
                List<Moshtari> list = new ArrayList<>();
                viewModel.getAllBazkhordWithCustomer().observe(this, moshtariWithBazkhords -> {
                    for (int i = 0; i < moshtariWithBazkhords.size(); i++) {
                        list.add(moshtariWithBazkhords.get(i).moshtari);
                    }
                    initRecyclerViewCustomers(list);
                });
                txt_name_report.setText("ليست مشتريان");
                break;
            case "reserves":
                typeReport = 3;
                viewModel.getAllReserve().observe(this, reserves -> {
                    for (int i = 0; i < reserves.size(); i++) {
                        reserves.get(i).setNameMosh(viewModel.getMoshtariName(reserves.get(i).getIdMoshtari()));
                    }
                    initRecyclerViewReserve(reserves);
                });
                txt_name_report.setText("ليست رزرو ها");
                break;
            case "pays":
                btn_show_search_report.setVisibility(View.GONE);
                typeReport = 4;
                viewModel.getAllPays().observe(this, pardakhthas -> {
                    for (int i = 0; i < pardakhthas.size(); i++) {
                        pardakhthas.get(i).setMoshName(viewModel.getMoshtariName(pardakhthas.get(i).getIdMoshtari()));
                    }
                    initPaysRecyclerView(pardakhthas);
                });
                txt_name_report.setText("پرداخت ها");
                break;
            case "factors":
                typeReport = 5;
                viewModel.getAllFactors().observe(this, factors -> {
                    for (int i = 0; i < factors.size(); i++) {
                        factors.get(i).setMoshName(viewModel.getMoshtariName(factors.get(i).getIdMoshtari()));
                        factors.get(i).setRizNum(String.valueOf(viewModel.getCountRizFactor(factors.get(i).getId())));
                    }
                    initFactorsRecyclerView(factors);
                });
                txt_name_report.setText("لیست فاکتور ها");
                break;
        }
    }

    private void initFactorsRecyclerView(List<Factor> factors) {
        factorAdapter = new FactorAdapter(factors, new FactorAdapter.onFactorItemListener() {
            @Override
            public void onClickPay(@NotNull Factor factor) {
                payTheFactor(factor);
                factor.setPardakhtShode(true);
                viewModel.updateFactor(factor);
                viewModel.loadFactors();
            }

            @Override
            public void onClickDetails(@NotNull Factor factor) {
                Intent intent = new Intent(ListReportActivity.this, DetailFactorActivity.class);
                intent.putExtra("dataFactor", factor);
                startActivity(intent);
            }
        });
        rcl_reports.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcl_reports.setAdapter(factorAdapter);
        checkEmptyListFactor();
    }

    private void payTheFactor(Factor factor) {
        Pardakhtha pardakhtha = new Pardakhtha();
        pardakhtha.setIdFactor(factor.getId());
        pardakhtha.setNoePardakht("نقدی");
        pardakhtha.setExpend(false);
        pardakhtha.setShomareFactor(String.valueOf(factor.getShomareFactor()));
        pardakhtha.setMablagePardakht(String.valueOf(factor.getJameKol()));
        pardakhtha.setShomarePeygiri(String.valueOf(factor.getShomareFactor() + 1000));
        pardakhtha.setTarikhPardakht(CalenderGenerator.getCurrentShamsidate());
        pardakhtha.setIdMoshtari(factor.getIdMoshtari());
        viewModel.addPay(pardakhtha);
    }

    private void initPaysRecyclerView(List<Pardakhtha> pardakhthas) {
        paysAdapter = new PaysAdapter(pardakhthas);
        rcl_reports.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcl_reports.setAdapter(paysAdapter);
        checkEmptyListPay();
    }

    private void initRecyclerViewFoods(List<Ghaza> ghazaList) {
        ghazaAdapter = new GhazaApadter(ghazaList, ghaza -> {
            Intent intent = new Intent(ListReportActivity.this, FoodDetailActivity.class);
            intent.putExtra("food", ghaza);
            startActivity(intent);
        });
        rcl_reports.setLayoutManager(new GridLayoutManager(this, 2));
        rcl_reports.setAdapter(ghazaAdapter);
        checkEmptyListGhaza();
    }

    private void initRecyclerViewComments(List<BazKhord> bazKhordList) {
        commentAdapter = new CommentAdapter(bazKhordList);
        rcl_reports.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcl_reports.setAdapter(commentAdapter);
        checkEmptyListComment();
    }

    private void initRecyclerViewCustomers(List<Moshtari> moshtaris) {
        moshtariAdapter = new MoshtariAdapter(moshtaris, true, this);
        rcl_reports.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcl_reports.setAdapter(moshtariAdapter);
    }

    private void initRecyclerViewReserve(List<Reserve> reserves) {
        reservesAdapter = new ReservesAdapter(reserves, reserve -> {
            reservesAdapter.removeItem(reserve);
            viewModel.deleteReserve(reserve);
            checkEmptyListReserve();
        });
        rcl_reports.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcl_reports.setAdapter(reservesAdapter);
        checkEmptyListReserve();
    }

    private void checkEmptyListGhaza() {
        if (ghazaAdapter.getItemCount() == 0) {
            txt_no_found_report.setVisibility(View.VISIBLE);
        } else {
            txt_no_found_report.setVisibility(View.GONE);
        }
    }

    private void checkEmptyListComment() {
        if (commentAdapter.getItemCount() == 0) {
            txt_no_found_report.setVisibility(View.VISIBLE);
        } else {
            txt_no_found_report.setVisibility(View.GONE);
        }
    }

    private void checkEmptyListReserve() {
        if (reservesAdapter.getItemCount() == 0) {
            txt_no_found_report.setText("رزروی یافت نشد");
            txt_no_found_report.setVisibility(View.VISIBLE);
        } else {
            txt_no_found_report.setVisibility(View.GONE);
        }
    }

    private void checkEmptyListPay() {
        if (paysAdapter.getItemCount() == 0) {
            txt_no_found_report.setText("پرداختی یافت نشد");
            txt_no_found_report.setVisibility(View.VISIBLE);
        } else {
            txt_no_found_report.setVisibility(View.GONE);
        }
    }

    private void checkEmptyListFactor() {
        if (factorAdapter.getItemCount() == 0) {
            txt_no_found_report.setText("فاکتوری یافت نشد");
            txt_no_found_report.setVisibility(View.VISIBLE);
        } else {
            txt_no_found_report.setVisibility(View.GONE);
        }
    }

    private void checkEmptyListCustomer() {
        if (moshtariAdapter.getItemCount() == 0) {
            txt_no_found_report.setText("مشتری یافت نشد");
            txt_no_found_report.setVisibility(View.VISIBLE);
        } else {
            txt_no_found_report.setVisibility(View.GONE);
        }
    }

    private void initViews() {
        rcl_reports = findViewById(R.id.rcl_reports);
        btn_back = findViewById(R.id.btn_back_comments);
        txt_no_found_report = findViewById(R.id.txt_no_found_report);
        txt_name_report = findViewById(R.id.txt_name_report);
        btn_show_search_report = findViewById(R.id.btn_show_search_report);
        edt_search_report = findViewById(R.id.edt_search_report);
    }

    @Override
    public void onMoshtariClick(@NotNull Moshtari moshtari) {
        Intent intent = new Intent(this, CustomerDetailActivity.class);
        intent.putExtra("customer", moshtari);
        startActivity(intent);
    }
}