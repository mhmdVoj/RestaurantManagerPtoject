package com.project.farjad.restaurantproject.model.classHelpers;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Moshtari;

import java.util.List;

public class MoshtariWithBazkhord {
    @Embedded
    public Moshtari moshtari;
    @Relation(
            parentColumn = "id",
            entityColumn = "id_moshtari"
    )
    public List<BazKhord> bazKhordList;

    public Moshtari getMoshtari() {
        return moshtari;
    }

    public void setMoshtari(Moshtari moshtari) {
        this.moshtari = moshtari;
    }

    public List<BazKhord> getBazKhordList() {
        return bazKhordList;
    }

    public void setBazKhordList(List<BazKhord> bazKhordList) {
        this.bazKhordList = bazKhordList;
    }
}
