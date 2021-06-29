package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithBazkhord;
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Ghaza>> allGhazas = new MutableLiveData<>();
    private MutableLiveData<List<NoeGhazaWithGhaza>> allNoeGhaza = new MutableLiveData<>();
    private MutableLiveData<Boolean> TypeFoodPrg = new MutableLiveData<>();
    private MutableLiveData<Boolean> FoodPrg = new MutableLiveData<>();
    private MutableLiveData<List<MoshtariWithBazkhord>> lastBazkhords = new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public HomeViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        TypeFoodPrg.setValue(true);
        FoodPrg.setValue(true);
        restaurantDao.getFoods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Ghaza>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Ghaza> ghazas) {
                        if (ghazas.size() > 5)
                            allGhazas.setValue(ghazas);
                        FoodPrg.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
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
                        TypeFoodPrg.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getMoshtariWithBazkhord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<MoshtariWithBazkhord>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<MoshtariWithBazkhord> moshtariWithBazkhords) {
                        //lastBazkhords.setValue(moshtariWithBazkhords.subList(0,2));
                        lastBazkhords.setValue(moshtariWithBazkhords);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }



    public void refreshHomeFragment(){
        FoodPrg.setValue(true);
        TypeFoodPrg.setValue(true);
        restaurantDao.getFoods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Ghaza>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Ghaza> ghazas) {
                        if (ghazas.size() > 5)
                            allGhazas.setValue(ghazas);
                        FoodPrg.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
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
                        TypeFoodPrg.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public LiveData<List<Ghaza>> getAllGhazas() {
        return allGhazas;
    }

    public LiveData<List<NoeGhazaWithGhaza>> getAllNoeGhaza() {
        return allNoeGhaza;
    }

    public LiveData<Boolean> getFoodPrg() {
        return FoodPrg;
    }

    public String getGhazaName(long id){
        return restaurantDao.getFood(id).getName();
    }

    public String getTypeGhaza(long id){
        return restaurantDao.getNoeGhaza(id).getName();
    }

    public LiveData<Boolean> getTypeFoodPrg() {
        return TypeFoodPrg;
    }

    public LiveData<List<MoshtariWithBazkhord>> getLastBazkhords() {
        return lastBazkhords;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
