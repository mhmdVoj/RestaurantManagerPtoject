package com.project.farjad.restaurantproject.viewModels;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Pardakhtha;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FinancialFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Pardakhtha>> lastPays = new MutableLiveData<>();
    private MutableLiveData<List<Factor>> lastFactors = new MutableLiveData<>();
    private MutableLiveData<Boolean> prgPays = new MutableLiveData<>();
    private MutableLiveData<Boolean> prgFactors = new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public FinancialFragmentViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        prgFactors.setValue(true);
        prgPays.setValue(true);
        restaurantDao.getFactors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Factor>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Factor> factors) {
                        if (factors.size()>= 1){
                            lastFactors.setValue(factors);
                        }
                        prgFactors.setValue(false);
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
                        if (pardakhthas.size() >=1){
                            lastPays.setValue(pardakhthas);
                        }
                        prgPays.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public String getMoshtariName(long id){
        return restaurantDao.getMoshtari(id).getName();
    }

    public LiveData<Boolean> getPrgFactors() {
        return prgFactors;
    }

    public LiveData<List<Factor>> getLastFactors() {
        return lastFactors;
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
                        if (factors.size()>= 1){
                            lastFactors.setValue(factors);
                        }
                        prgFactors.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void loadPays(){
        restaurantDao.getPays()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Pardakhtha>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Pardakhtha> pardakhthas) {
                        if (pardakhthas.size() >=1){
                            lastPays.setValue(pardakhthas);
                        }
                        prgPays.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public int getCountRizFactor(long id){
        return restaurantDao.getFactorWithRizFactorCount(id).rizFactorList.size();
    }

    public LiveData<Boolean> getPrgPays() {
        return prgPays;
    }

    public LiveData<List<Pardakhtha>> getLastPays() {
        return lastPays;
    }
}
