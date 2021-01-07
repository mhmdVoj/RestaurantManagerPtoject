package com.project.farjad.restaurantproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Moshtari implements Parcelable {
    @PrimaryKey(autoGenerate = true) private long id;
    private String name;
    private String shomareTel;
    private String shomareEshtrrak;
    private String address;


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

    public String getShomareTel() {
        return shomareTel;
    }

    public void setShomareTel(String shomareTel) {
        this.shomareTel = shomareTel;
    }

    public String getShomareEshtrrak() {
        return shomareEshtrrak;
    }

    public void setShomareEshtrrak(String shomareEshtrrak) {
        this.shomareEshtrrak = shomareEshtrrak;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Moshtari() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.shomareTel);
        dest.writeString(this.shomareEshtrrak);
        dest.writeString(this.address);
    }

    protected Moshtari(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.shomareTel = in.readString();
        this.shomareEshtrrak = in.readString();
        this.address = in.readString();
    }

    public static final Parcelable.Creator<Moshtari> CREATOR = new Parcelable.Creator<Moshtari>() {
        @Override
        public Moshtari createFromParcel(Parcel source) {
            return new Moshtari(source);
        }

        @Override
        public Moshtari[] newArray(int size) {
            return new Moshtari[size];
        }
    };
}
