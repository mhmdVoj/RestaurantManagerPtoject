package com.project.farjad.restaurantproject.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.Reserve;
import com.project.farjad.restaurantproject.tools.CalenderGenerator;

import java.util.Iterator;
import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CustomerFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Moshtari>> allMoshtari = new MutableLiveData<>();
    private MutableLiveData<List<BazKhord>> allBazkhord = new MutableLiveData<>();
    private MutableLiveData<List<Reserve>> allReserves = new MutableLiveData<>();
    private RestaurantDao restaurantDao;

    public CustomerFragmentViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        loadMoshtari();
        loadComments();
        loadReserves();
    }

    public void loadMoshtari(){
        restaurantDao.getMoshtari()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Moshtari>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Moshtari> moshtaris) {
                        allMoshtari.setValue(moshtaris);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void loadComments(){
        restaurantDao.getComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<BazKhord>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<BazKhord> bazKhordList) {
                        allBazkhord.setValue(bazKhordList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void loadReserves(){
        restaurantDao.getReserves()
                .filter(reserves ->{
                    Iterator<Reserve> i = reserves.iterator();
                    while (i.hasNext()) {
                        Reserve r = i.next(); // must be called before you can call i.remove()
                        if (!(r.getRozeReserve().equals(CalenderGenerator.getCurrentDay())))
                            i.remove();
                    } return true;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<Reserve>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Reserve> reserves) {
                        allReserves.setValue(reserves);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void refreshCustomerFragment(){
        loadMoshtari();
        loadComments();
    }

    public String getMoshtariName(long id){
        return restaurantDao.getMoshtari(id).getName();
    }

    public LiveData<List<Moshtari>> getAllMoshtari() {
        return allMoshtari;
    }

    public LiveData<List<BazKhord>> getAllBazkhord() {
        return allBazkhord;
    }

    public LiveData<List<Reserve>> getAllReserves() {
        return allReserves;
    }
}
