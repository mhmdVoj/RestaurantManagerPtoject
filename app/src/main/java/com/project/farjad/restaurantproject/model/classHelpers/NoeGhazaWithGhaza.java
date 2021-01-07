package com.project.farjad.restaurantproject.model.classHelpers;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.NoeGhaza;

import java.util.List;

public class NoeGhazaWithGhaza implements Parcelable {

    @Embedded public NoeGhaza noeGhaza;
    @Relation(
            parentColumn = "id",
            entityColumn = "id_noeGhaza"
    )
    public List<Ghaza> ghazaList;

    public NoeGhaza getNoeGhaza() {
        return noeGhaza;
    }

    public void setNoeGhaza(NoeGhaza noeGhaza) {
        this.noeGhaza = noeGhaza;
    }

    public List<Ghaza> getGhazaList() {
        return ghazaList;
    }

    public void setGhazaList(List<Ghaza> ghazaList) {
        this.ghazaList = ghazaList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.noeGhaza, flags);
        dest.writeTypedList(this.ghazaList);
    }

    public NoeGhazaWithGhaza() {
    }

    protected NoeGhazaWithGhaza(Parcel in) {
        this.noeGhaza = in.readParcelable(NoeGhaza.class.getClassLoader());
        this.ghazaList = in.createTypedArrayList(Ghaza.CREATOR);
    }

    public static final Parcelable.Creator<NoeGhazaWithGhaza> CREATOR = new Parcelable.Creator<NoeGhazaWithGhaza>() {
        @Override
        public NoeGhazaWithGhaza createFromParcel(Parcel source) {
            return new NoeGhazaWithGhaza(source);
        }

        @Override
        public NoeGhazaWithGhaza[] newArray(int size) {
            return new NoeGhazaWithGhaza[size];
        }
    };
}
