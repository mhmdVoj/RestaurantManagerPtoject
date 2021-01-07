package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.classHelpers.GhazaWithBazkhord;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailFoodViewModel extends ViewModel {
    private MutableLiveData<List<GhazaWithBazkhord>> ghazaWithBazkhod = new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public DetailFoodViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getGhazaWithBazkhord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<GhazaWithBazkhord>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<GhazaWithBazkhord> ghazaWithBazkhords) {
                        ghazaWithBazkhod.setValue(ghazaWithBazkhords);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public String getMoshtariName(long id){
        return restaurantDao.getMoshtari(id).getName();
    }

    public void updateFood(Ghaza ghaza){
        restaurantDao.updateFood(ghaza);
    }

    public void deleteFood(Ghaza ghaza){
        restaurantDao.deleteFood(ghaza);
    }

    public LiveData<List<GhazaWithBazkhord>> getGhazaWithBazkhod() {
        return ghazaWithBazkhod;
    }
}
