package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.Pardakhtha;
import com.project.farjad.restaurantproject.model.Reserve;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithBazkhord;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ReportViewModel extends ViewModel {
    private MutableLiveData<List<MoshtariWithBazkhord>> allBazkhordWithCustomer= new MutableLiveData<>();
    private MutableLiveData<List<Reserve>> allReserve = new MutableLiveData<>();
    private MutableLiveData<List<Factor>> allFactors = new MutableLiveData<>();
    private MutableLiveData<List<Pardakhtha>> allPays = new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public ReportViewModel(RestaurantDao restaurantDao) {
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
                        allBazkhordWithCustomer.setValue(moshtariWithBazkhords);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getReserves()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Reserve>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Reserve> reserves) {
                        allReserve.setValue(reserves);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getFactors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Factor>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Factor> factors) {
                        allFactors.setValue(factors);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getPays()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Pardakhtha>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Pardakhtha> pardakhthas) {
                        allPays.setValue(pardakhthas);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    public LiveData<List<MoshtariWithBazkhord>> getAllBazkhordWithCustomer() {
        return allBazkhordWithCustomer;
    }

    public void deleteReserve(Reserve reserve){
        restaurantDao.deleteReserve(reserve);
    }

    public void updateFactor(Factor factor){
        restaurantDao.updateFactor(factor);
    }

    public void addPay(Pardakhtha pardakhtha){
        restaurantDao.addPay(pardakhtha);
    }

    public String getMoshtariName(long id){
        return restaurantDao.getMoshtari(id).getName();
    }

    public String getGhazaName(long id){
        return restaurantDao.getFood(id).getName();
    }

    public void loadFactors(){
        restaurantDao.getFactors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Factor>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Factor> factors) {
                        allFactors.setValue(factors);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public LiveData<List<Factor>> getAllFactors() {
        return allFactors;
    }

    public LiveData<List<Reserve>> getAllReserve() {
        return allReserve;
    }

    public LiveData<List<Pardakhtha>> getAllPays() {
        return allPays;
    }

    public int getCountRizFactor(long id){
        return restaurantDao.getFactorWithRizFactorCount(id).rizFactorList.size();
    }
}
