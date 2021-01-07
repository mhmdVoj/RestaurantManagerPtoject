package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.tools.DataFakerGenerator;

public class LogInViewModel extends ViewModel {
    private RestaurantDao restaurantDao;
    private MutableLiveData<Boolean> prg = new MutableLiveData<>();

    public LogInViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public void addData() {
        prg.setValue(true);
        for (int i = 0; i < DataFakerGenerator.getGhaza().size(); i++) { restaurantDao.addFood(DataFakerGenerator.getGhaza().get(i)); }
        for (int i = 0; i < DataFakerGenerator.getNoeGahaza().size(); i++) { restaurantDao.addTypeFood(DataFakerGenerator.getNoeGahaza().get(i)); }
        for (int i = 0; i < DataFakerGenerator.getComments().size(); i++) { restaurantDao.addComment(DataFakerGenerator.getComments().get(i)); }
        for (int i = 0; i < DataFakerGenerator.getMoshtaris().size(); i++) { restaurantDao.addCustomer(DataFakerGenerator.getMoshtaris().get(i)); }
        for (int i = 0; i < DataFakerGenerator.getSemasts().size(); i++) { restaurantDao.addSemat(DataFakerGenerator.getSemasts().get(i)); }
        for (int i = 0; i < DataFakerGenerator.getPersonnel().size(); i++) { restaurantDao.addPersonnel(DataFakerGenerator.getPersonnel().get(i)); }
        prg.setValue(false);
    }

    public LiveData<Boolean> getPrg() {
        return prg;
    }
}
