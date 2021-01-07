package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.Pardakhtha;
import com.project.farjad.restaurantproject.model.RizFactor;
import com.project.farjad.restaurantproject.model.classHelpers.FactorWithRizFactor;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FactorChangeViewModel extends ViewModel {
    private RestaurantDao restaurantDao;
    private MutableLiveData<List<FactorWithRizFactor>> factorRizFactors = new MutableLiveData<>();

    public FactorChangeViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getFactorWithRizFactor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<FactorWithRizFactor>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<FactorWithRizFactor> factorWithRizFactors) {
                        factorRizFactors.setValue(factorWithRizFactors);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void loadRizFactors(){
        restaurantDao.getFactorWithRizFactor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<FactorWithRizFactor>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<FactorWithRizFactor> factorWithRizFactors) {
                        factorRizFactors.setValue(factorWithRizFactors);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public long addFactor(Factor factor){
        return restaurantDao.addFactor(factor);
    }

    public void updateFactor(Factor factor){
        restaurantDao.updateFactor(factor);
    }

    public void deleteFactor(Factor factor){
        restaurantDao.deleteFactor(factor);
    }

    public void updateRizFactor(RizFactor rizFactor){
        restaurantDao.updateRizFactor(rizFactor);
    }

    public void addPay(Pardakhtha pardakhtha){
        restaurantDao.addPay(pardakhtha);
    }

    public void deleteRiz(RizFactor rizFactor){
        restaurantDao.deleteRizFactor(rizFactor);
    }

    public Ghaza getGhaza(long id){
        return restaurantDao.getFood(id);
    }

    public LiveData<List<FactorWithRizFactor>> getFactorRizFactors() {
        return factorRizFactors;
    }

    public long addRizFactor(RizFactor rizFactor){
        return restaurantDao.addRizFactor(rizFactor);
    }
}
