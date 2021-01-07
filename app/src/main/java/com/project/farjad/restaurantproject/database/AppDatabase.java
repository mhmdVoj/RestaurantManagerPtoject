package com.project.farjad.restaurantproject.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.NoeGhaza;
import com.project.farjad.restaurantproject.model.Pardakhtha;
import com.project.farjad.restaurantproject.model.Personel;
import com.project.farjad.restaurantproject.model.Reserve;
import com.project.farjad.restaurantproject.model.RizFactor;
import com.project.farjad.restaurantproject.model.Semat;

@Database(entities = {Ghaza.class, NoeGhaza.class, BazKhord.class, Moshtari.class,
        Reserve.class, Factor.class, RizFactor.class, Pardakhtha.class, Personel.class, Semat.class}, exportSchema = false,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase appDatabase;

    public static   AppDatabase getAppDatabase(Context context) {
        if (appDatabase ==null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"restaurantDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    abstract public RestaurantDao restaurantDao();
}
