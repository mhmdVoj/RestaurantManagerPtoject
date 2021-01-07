package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Personel;
import com.project.farjad.restaurantproject.model.Semat;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PersonnelViewModel extends ViewModel {
    private RestaurantDao restaurantDao;
    private MutableLiveData<List<Personel>> allPersonels = new MutableLiveData<>();
    private MutableLiveData<List<Semat>> allSemats = new MutableLiveData<>();

    public PersonnelViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        restaurantDao.getPersonnel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Personel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Personel> personels) {
                        allPersonels.setValue(personels);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        restaurantDao.getSemat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Semat>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Semat> semats) {
                        allSemats.setValue(semats);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void deletePersonnel(Personel personel){
        restaurantDao.deletePersonnel(personel);
    }

    public LiveData<List<Personel>> getAllPersonels() {
        return allPersonels;
    }

    public void addPersonnel(Personel personel){
        restaurantDao.addPersonnel(personel);
    }

    public LiveData<List<Semat>> getAllSemats() {
        return allSemats;
    }

    public Semat getSemat(long id){
        return restaurantDao.getSemat(id);
    }
}
