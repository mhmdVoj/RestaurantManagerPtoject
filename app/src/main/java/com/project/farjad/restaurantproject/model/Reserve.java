package com.project.farjad.restaurantproject.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Moshtari.class,
        parentColumns = "id",
        childColumns = "idMoshtari",
        onDelete = ForeignKey.RESTRICT))
public class Reserve {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private boolean isVip;
    private String tarikhSabtReserve;
    private String saatReserve;
    private String rozeReserve;
    private String tarikhReserve;
    private String shomareMiz;
    private String tedad;
    private long idMoshtari;

    @Ignore
    private String nameMosh;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getTarikhSabtReserve() {
        return tarikhSabtReserve;
    }

    public void setTarikhSabtReserve(String tarikhSabtReserve) {
        this.tarikhSabtReserve = tarikhSabtReserve;
    }

    public String getSaatReserve() {
        return saatReserve;
    }

    public void setSaatReserve(String saatReserve) {
        this.saatReserve = saatReserve;
    }

    public String getRozeReserve() {
        return rozeReserve;
    }

    public void setRozeReserve(String rozeReserve) {
        this.rozeReserve = rozeReserve;
    }

    public String getTarikhReserve() {
        return tarikhReserve;
    }

    public void setTarikhReserve(String tarikhReserve) {
        this.tarikhReserve = tarikhReserve;
    }

    public String getShomareMiz() {
        return shomareMiz;
    }

    public void setShomareMiz(String shomareMiz) {
        this.shomareMiz = shomareMiz;
    }

    public String getTedad() {
        return tedad;
    }

    public void setTedad(String tedad) {
        this.tedad = tedad;
    }

    public long getIdMoshtari() {
        return idMoshtari;
    }

    public void setIdMoshtari(long idMoshtari) {
        this.idMoshtari = idMoshtari;
    }

    public String getNameMosh() {
        return nameMosh;
    }

    public void setNameMosh(String nameMosh) {
        this.nameMosh = nameMosh;
    }
}
