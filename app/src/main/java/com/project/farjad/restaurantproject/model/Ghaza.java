package com.project.farjad.restaurantproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(foreignKeys =
@ForeignKey(entity = NoeGhaza.class,
        parentColumns = "id",
        childColumns = "id_noeGhaza",
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.SET_NULL))
public class Ghaza implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String imgGhaza;
    private String gheymat;
    private boolean mojodi;
    private int nomre;
    private String tozih;
    private long id_noeGhaza;

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

    public String getImgGhaza() {
        return imgGhaza;
    }

    public void setImgGhaza(String imgGhaza) {
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

    @Ignore
    private String type;


    public Ghaza() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public long getId_noeGhaza() {
        return id_noeGhaza;
    }

    public void setId_noeGhaza(long id_noeGhaza) {
        this.id_noeGhaza = id_noeGhaza;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.imgGhaza);
        dest.writeString(this.gheymat);
        dest.writeByte(this.mojodi ? (byte) 1 : (byte) 0);
        dest.writeInt(this.nomre);
        dest.writeString(this.tozih);
        dest.writeLong(this.id_noeGhaza);
        dest.writeString(this.type);
    }

    protected Ghaza(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.imgGhaza = in.readString();
        this.gheymat = in.readString();
        this.mojodi = in.readByte() != 0;
        this.nomre = in.readInt();
        this.tozih = in.readString();
        this.id_noeGhaza = in.readLong();
        this.type = in.readString();
    }

    public static final Creator<Ghaza> CREATOR = new Creator<Ghaza>() {
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
