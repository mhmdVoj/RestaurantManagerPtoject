package com.project.farjad.restaurantproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class NoeGhaza implements Parcelable {
    @PrimaryKey(autoGenerate = true) private long id;
    private String name;
    private int imgResource;


    //this not in database
    @Ignore private boolean isChecked = false;


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

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.imgResource);
        dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }

    public NoeGhaza() {
    }

    protected NoeGhaza(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.imgResource = in.readInt();
        this.isChecked = in.readByte() != 0;
    }

    public static final Parcelable.Creator<NoeGhaza> CREATOR = new Parcelable.Creator<NoeGhaza>() {
        @Override
        public NoeGhaza createFromParcel(Parcel source) {
            return new NoeGhaza(source);
        }

        @Override
        public NoeGhaza[] newArray(int size) {
            return new NoeGhaza[size];
        }
    };
}
