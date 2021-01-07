package com.project.farjad.restaurantproject.viewModels;

import androidx.lifecycle.ViewModel;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.model.Reserve;

public class ReserveChangeViewModel extends ViewModel {
    private RestaurantDao restaurantDao;

    public ReserveChangeViewModel(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public void addReserve(Reserve reserve){
        restaurantDao.addReserve(reserve);
    }
}
