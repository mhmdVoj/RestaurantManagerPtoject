package com.project.farjad.restaurantproject.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Moshtari.class,
        parentColumns = "id",
        childColumns = "idMoshtari",
        onDelete = ForeignKey.SET_NULL))
public class Factor implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long shomareFactor;
    private long idMoshtari;
    private String tarikh;
    private int jameKol;
    private int takhfif;
    private boolean pardakhtShode;
    @Ignore
    private String rizNum;
    @Ignore
    private String moshName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getShomareFactor() {
        return shomareFactor;
    }

    public void setShomareFactor(long shomareFactor) {
        this.shomareFactor = shomareFactor;
    }

    public long getIdMoshtari() {
        return idMoshtari;
    }

    public void setIdMoshtari(long idMoshtari) {
        this.idMoshtari = idMoshtari;
    }

    public String getTarikh() {
        return tarikh;
    }

    public void setTarikh(String tarikh) {
        this.tarikh = tarikh;
    }

    public int getJameKol() {
        return jameKol;
    }

    public void setJameKol(int jameKol) {
        this.jameKol = jameKol;
    }

    public int getTakhfif() {
        return takhfif;
    }

    public void setTakhfif(int takhfif) {
        this.takhfif = takhfif;
    }

    public String getMoshName() {
        return moshName;
    }

    public void setMoshName(String moshName) {
        this.moshName = moshName;
    }

    public boolean isPardakhtShode() {
        return pardakhtShode;
    }

    public void setPardakhtShode(boolean pardakhtShode) {
        this.pardakhtShode = pardakhtShode;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.shomareFactor);
        dest.writeLong(this.idMoshtari);
        dest.writeString(this.tarikh);
        dest.writeInt(this.jameKol);
        dest.writeInt(this.takhfif);
        dest.writeByte(this.pardakhtShode ? (byte) 1 : (byte) 0);
        dest.writeString(this.moshName);
    }

    public Factor() {
    }

    protected Factor(Parcel in) {
        this.id = in.readLong();
        this.shomareFactor = in.readLong();
        this.idMoshtari = in.readLong();
        this.tarikh = in.readString();
        this.jameKol = in.readInt();
        this.takhfif = in.readInt();
        this.pardakhtShode = in.readByte() != 0;
        this.moshName = in.readString();
    }

    public static final Parcelable.Creator<Factor> CREATOR = new Parcelable.Creator<Factor>() {
        @Override
        public Factor createFromParcel(Parcel source) {
            return new Factor(source);
        }

        @Override
        public Factor[] newArray(int size) {
            return new Factor[size];
        }
    };

    public String getRizNum() {
        return rizNum;
    }

    public void setRizNum(String rizNum) {
        this.rizNum = rizNum;
    }
}
