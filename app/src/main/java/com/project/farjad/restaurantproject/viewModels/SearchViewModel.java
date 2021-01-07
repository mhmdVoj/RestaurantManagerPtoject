package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Ghaza;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends ViewModel {
    private MutableLiveData<List<Ghaza>> allGhaza =new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public SearchViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getFoods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Ghaza>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Ghaza> ghazas) {
                        allGhaza.setValue(ghazas);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public LiveData<List<Ghaza>> getAllGhaza() {
        return allGhaza;
    }
}
