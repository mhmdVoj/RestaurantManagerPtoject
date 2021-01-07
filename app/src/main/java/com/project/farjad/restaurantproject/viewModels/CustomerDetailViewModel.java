package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.Reserve;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithBazkhord;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithPay;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithReseve;

import java.util.Iterator;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CustomerDetailViewModel extends ViewModel {
    private MutableLiveData<List<MoshtariWithBazkhord>> allBazkhords = new MutableLiveData<>();
    private MutableLiveData<List<MoshtariWithReseve>> allReserve =new MutableLiveData<>();
    private MutableLiveData<List<MoshtariWithPay>> allPays = new MutableLiveData<>();
    private MutableLiveData<Integer> ReserveCount = new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public CustomerDetailViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getMoshtariWithBazkhord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<MoshtariWithBazkhord>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<MoshtariWithBazkhord> moshtariWithBazkhords) {
                        allBazkhords.setValue(moshtariWithBazkhords);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getMoshtariWithReserves()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<MoshtariWithReseve>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<MoshtariWithReseve> moshtariWithReseves) {
                        allReserve.setValue(moshtariWithReseves);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getMoshtariWithPay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<MoshtariWithPay>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<MoshtariWithPay> moshtariWithPays) {
                        allPays.setValue(moshtariWithPays);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void deleteMoshtari(Moshtari moshtari){
        restaurantDao.deleteMoshtari(moshtari);
    }

    public LiveData<List<MoshtariWithBazkhord>> getAllBazkhords() {
        return allBazkhords;
    }

    public LiveData<List<MoshtariWithReseve>> getAllReserve() {
        return allReserve;
    }

    public LiveData<List<MoshtariWithPay>> getAllPays() {
        return allPays;
    }
}
