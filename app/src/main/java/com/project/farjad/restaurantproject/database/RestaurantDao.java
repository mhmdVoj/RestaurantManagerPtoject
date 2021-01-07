package com.project.farjad.restaurantproject.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

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
import com.project.farjad.restaurantproject.model.classHelpers.FactorWithRizFactor;
import com.project.farjad.restaurantproject.model.classHelpers.GhazaWithBazkhord;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithBazkhord;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithPay;
import com.project.farjad.restaurantproject.model.classHelpers.MoshtariWithReseve;
import com.project.farjad.restaurantproject.model.classHelpers.NoeGhazaWithGhaza;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface RestaurantDao {

    //Foods Database Functions -->
    @Insert
    long addFood(Ghaza ghaza);

    @Query("SELECT * FROM ghaza ORDER BY id DESC")
    Single<List<Ghaza>> getFoods();

    @Query("SELECT * FROM ghaza WHERE id = :id")
    Ghaza getFood(long id);

    @Update
    int updateFood(Ghaza ghaza);

    @Delete
    void deleteFood(Ghaza ghaza);


    //typeFood Database Functions -->
    @Insert
    long addTypeFood(NoeGhaza noeGhaza);


    //Comments Database Functions -->
    @Insert
    long addComment(BazKhord bazKhord);

    @Query("SELECT * FROM bazkhord")
    Single<List<BazKhord>> getComments();

    //Factor Database Functions -->
    @Insert
    long addFactor(Factor factor);

    @Query("SELECT * FROM factor ORDER BY id DESC")
    Single<List<Factor>> getFactors();

    @Query("SELECT * FROM factor WHERE id = :id")
    Factor getFactor(long id);

    @Update
    void updateFactor(Factor factor);

    @Delete
    void deleteFactor(Factor factor);

    //Pays Database Functions -->
    @Insert
    long addPay(Pardakhtha pardakhtha);

    @Query("SELECT * FROM pardakhtha ORDER BY id DESC")
    Single<List<Pardakhtha>> getPays();

    //Moshtari Database Functions -->
    @Insert
    long addCustomer(Moshtari moshtari);

    @Query("SELECT * FROM moshtari WHERE id = :id")
    Moshtari getMoshtari(long id);

    @Delete
    void deleteMoshtari(Moshtari moshtari);

    @Query("SELECT * FROM moshtari ORDER BY id DESC")
    Single<List<Moshtari>> getMoshtari();

    //RizFactor Database Function -->
    @Insert
    long addRizFactor(RizFactor rizFactor);

    @Update
    int updateRizFactor(RizFactor rizFactor);

    @Delete
    void deleteRizFactor(RizFactor rizFactor);

    //Reserves Database Functions -->
    @Insert
    long addReserve(Reserve reserve);

    @Query("SELECT * FROM reserve ORDER BY id DESC")
    Single<List<Reserve>> getReserves();

    @Delete
    void deleteReserve(Reserve reserve);

    //Personnel and semat database functions -->

    @Insert
    void addSemat(Semat semat);

    @Query("SELECT * FROM semat")
    Single<List<Semat>> getSemat();

    @Delete
    void deletePersonnel(Personel personel);

    @Insert
    void addPersonnel(Personel personel);

    @Query("SELECT * FROM semat WHERE id = :id")
    Semat getSemat(long id);

    @Query("SELECT * FROM personel")
    Single<List<Personel>> getPersonnel();

    //Relation Methods
    @Transaction
    @Query("SELECT * FROM noeghaza")
    Single<List<NoeGhazaWithGhaza>> getNoeGhazaWithGhaza();

    @Transaction
    @Query("SELECT * FROM Ghaza")
    Single<List<GhazaWithBazkhord>> getGhazaWithBazkhord();

    @Transaction
    @Query("SELECT * FROM Moshtari")
    Single<List<MoshtariWithBazkhord>> getMoshtariWithBazkhord();

    @Transaction
    @Query("SELECT * FROM Moshtari")
    Single<List<MoshtariWithReseve>> getMoshtariWithReserves();

    @Transaction
    @Query("SELECT * FROM factor")
    Single<List<FactorWithRizFactor>> getFactorWithRizFactor();

    @Transaction
    @Query("SELECT * FROM factor WHERE id = :id")
    FactorWithRizFactor getFactorWithRizFactorCount(long id);

    @Transaction
    @Query("SELECT * FROM moshtari")
    Single<List<MoshtariWithPay>> getMoshtariWithPay();



}
