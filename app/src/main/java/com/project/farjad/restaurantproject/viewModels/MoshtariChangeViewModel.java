package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Moshtari;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoshtariChangeViewModel extends ViewModel {
    public RestaurantDao restaurantDao;
    private MutableLiveData<List<Moshtari>> allMoshtri = new MutableLiveData<>();

    public MoshtariChangeViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getMoshtari()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Moshtari>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Moshtari> moshtaris) {
                        allMoshtri.setValue(moshtaris);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void addMoshtari(Moshtari moshtari){
        restaurantDao.addCustomer(moshtari);
    }

    public LiveData<List<Moshtari>> getAllMoshtri() {
        return allMoshtri;
    }
}
