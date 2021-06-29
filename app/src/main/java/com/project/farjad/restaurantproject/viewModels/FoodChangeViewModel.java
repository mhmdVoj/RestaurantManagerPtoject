package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FoodChangeViewModel extends ViewModel {
    private RestaurantDao restaurantDao;
    private MutableLiveData<List<NoeGhazaWithGhaza>> allNoeGhaza = new MutableLiveData<>();
    private MutableLiveData<List<Ghaza>> allFoods = new MutableLiveData<>();

    public FoodChangeViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getNoeGhazaWithGhaza()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<NoeGhazaWithGhaza>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<NoeGhazaWithGhaza> noeGhazaWithGhazas) {
                        allNoeGhaza.setValue(noeGhazaWithGhazas);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getFoods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Ghaza>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Ghaza> ghazas) {
                        allFoods.setValue(ghazas);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void addFood(Ghaza ghaza){
        restaurantDao.addFood(ghaza);
    }

    public LiveData<List<NoeGhazaWithGhaza>> getAllNoeGhaza() {
        return allNoeGhaza;
    }

    public String getTypeGhaza(long id){
        return restaurantDao.getNoeGhaza(id).getName();
    }

    public LiveData<List<Ghaza>> getAllFoods() {
        return allFoods;
    }
}
