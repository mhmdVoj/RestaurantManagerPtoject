package com.project.farjad.restaurantproject.model.classHelpers;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.RizFactor;

import java.util.List;

public class FactorWithRizFactor {
    @Embedded public Factor factor;
    @Relation(
            parentColumn = "id",
            entityColumn = "idFactor"
    )
    public List<RizFactor> rizFactorList;

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public List<RizFactor> getRizFactorList() {
        return rizFactorList;
    }

    public void setRizFactorList(List<RizFactor> rizFactorList) {
        this.rizFactorList = rizFactorList;
    }
}
