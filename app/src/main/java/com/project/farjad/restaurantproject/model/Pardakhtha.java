package com.project.farjad.restaurantproject.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Moshtari.class,
        parentColumns = "id",
        childColumns = "idMoshtari",
        onDelete = ForeignKey.RESTRICT))
public class Pardakhtha {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String tarikhPardakht;
    private String noePardakht;
    private String shomarePeygiri;
    private String mablagePardakht;
    private long idMoshtari;
    private String shomareFactor;

    @Ignore
    private boolean isExpend;
    @Ignore
    private String moshName;


    public boolean isExpend() {
        return isExpend;
    }

    public void setExpend(boolean expend) {
        isExpend = expend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTarikhPardakht() {
        return tarikhPardakht;
    }

    public void setTarikhPardakht(String tarikhPardakht) {
        this.tarikhPardakht = tarikhPardakht;
    }

    public String getNoePardakht() {
        return noePardakht;
    }

    public void setNoePardakht(String noePardakht) {
        this.noePardakht = noePardakht;
    }

    public String getMoshName() {
        return moshName;
    }

    public void setMoshName(String moshName) {
        this.moshName = moshName;
    }

    public String getShomarePeygiri() {
        return shomarePeygiri;
    }

    public void setShomarePeygiri(String shomarePeygiri) {
        this.shomarePeygiri = shomarePeygiri;
    }

    public String getMablagePardakht() {
        return mablagePardakht;
    }

    public void setMablagePardakht(String mablagePardakht) {
        this.mablagePardakht = mablagePardakht;
    }

    public String getShomareFactor() {
        return shomareFactor;
    }

    public void setShomareFactor(String shomareFactor) {
        this.shomareFactor = shomareFactor;
    }

    public long getIdMoshtari() {
        return idMoshtari;
    }

    public void setIdMoshtari(long idMoshtari) {
        this.idMoshtari = idMoshtari;
    }
}
