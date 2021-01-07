package com.project.farjad.restaurantproject.model.classHelpers;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Ghaza;

import java.util.List;

public class GhazaWithBazkhord {
    @Embedded public Ghaza ghaza;
    @Relation(
            parentColumn = "id",
            entityColumn = "id_ghaza"
    )
    public List<BazKhord> bazKhordList;

    public Ghaza getGhaza() {
        return ghaza;
    }

    public void setGhaza(Ghaza ghaza) {
        this.ghaza = ghaza;
    }

    public List<BazKhord> getBazKhordList() {
        return bazKhordList;
    }

    public void setBazKhordList(List<BazKhord> bazKhordList) {
        this.bazKhordList = bazKhordList;
    }
}
