package com.project.farjad.restaurantproject.model.classHelpers;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.Pardakhtha;

import java.util.List;

public class MoshtariWithPay {
    @Embedded public Moshtari moshtari;
    @Relation(
            parentColumn = "id",
            entityColumn = "idMoshtari"
    )
    public List<Pardakhtha> pardakhthaList;

    public Moshtari getMoshtari() {
        return moshtari;
    }

    public void setMoshtari(Moshtari moshtari) {
        this.moshtari = moshtari;
    }

    public List<Pardakhtha> getPardakhthaList() {
        return pardakhthaList;
    }

    public void setPardakhthaList(List<Pardakhtha> pardakhthaList) {
        this.pardakhthaList = pardakhthaList;
    }
}
