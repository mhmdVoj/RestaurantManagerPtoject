package com.project.farjad.restaurantproject.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ghaza implements Parcelable {
    private long id;
    private String name;
    private int imgGhaza;
    private String gheymat;
    private boolean mojodi;
    private int nomre;
    private String tozih;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgGhaza() {
        return imgGhaza;
    }

    public void setImgGhaza(int imgGhaza) {
        this.imgGhaza = imgGhaza;
    }

    public String getGheymat() {
        return gheymat;
    }

    public void setGheymat(String gheymat) {
        this.gheymat = gheymat;
    }

    public boolean isMojodi() {
        return mojodi;
    }

    public void setMojodi(boolean mojodi) {
        this.mojodi = mojodi;
    }

    public int getNomre() {
        return nomre;
    }

    public void setNomre(int nomre) {
        this.nomre = nomre;
    }

    public String getTozih() {
        return tozih;
    }

    public void setTozih(String tozih) {
        this.tozih = tozih;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.imgGhaza);
        dest.writeString(this.gheymat);
        dest.writeByte(this.mojodi ? (byte) 1 : (byte) 0);
        dest.writeInt(this.nomre);
        dest.writeString(this.tozih);
    }

    public Ghaza() {
    }

    protected Ghaza(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.imgGhaza = in.readInt();
        this.gheymat = in.readString();
        this.mojodi = in.readByte() != 0;
        this.nomre = in.readInt();
        this.tozih = in.readString();
    }

    public static final Parcelable.Creator<Ghaza> CREATOR = new Parcelable.Creator<Ghaza>() {
        @Override
        public Ghaza createFromParcel(Parcel source) {
            return new Ghaza(source);
        }

        @Override
        public Ghaza[] newArray(int size) {
            return new Ghaza[size];
        }
    };
}
