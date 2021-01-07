package com.project.farjad.restaurantproject.model.classHelpers;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.Reserve;

import java.util.List;

public class MoshtariWithReseve {
    @Embedded public Moshtari moshtari;
    @Relation(
            parentColumn = "id",
            entityColumn = "idMoshtari"
    )
    public List<Reserve> reserveList;

    public Moshtari getMoshtari() {
        return moshtari;
    }

    public void setMoshtari(Moshtari moshtari) {
        this.moshtari = moshtari;
    }

    public List<Reserve> getReserveList() {
        return reserveList;
    }

    public void setReserveList(List<Reserve> reserveList) {
        this.reserveList = reserveList;
    }
}
