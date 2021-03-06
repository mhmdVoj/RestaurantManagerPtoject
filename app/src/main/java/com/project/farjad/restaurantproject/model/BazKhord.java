package com.project.farjad.restaurantproject.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Moshtari.class,
        parentColumns = "id",
        childColumns = "id_moshtari",
        onDelete = ForeignKey.RESTRICT),
        @ForeignKey(entity = Ghaza.class,
        parentColumns = "id",
        childColumns = "idGhaza",
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.CASCADE)
})
public class BazKhord {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String mant;
    private String tarikh;
    private long id_moshtari;
    private int rating;
    private long idGhaza;
    private int nomre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMant() {
        return mant;
    }

    public void setMant(String mant) {
        this.mant = mant;
    }

    public String getTarikh() {
        return tarikh;
    }

    public void setTarikh(String tarikh) {
        this.tarikh = tarikh;
    }

    public int getNomre() {
        return nomre;
    }

    public void setNomre(int nomre) {
        this.nomre = nomre;
    }

    public long getId_moshtari() {
        return id_moshtari;
    }

    public void setId_moshtari(long id_moshtari) {
        this.id_moshtari = id_moshtari;
    }



    @Ignore
    private String nameMosh;
    @Ignore
    private String nameGhaz;

    public String getNameMosh() {
        return nameMosh;
    }

    public void setNameMosh(String nameMosh) {
        this.nameMosh = nameMosh;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNameGhaz() {
        return nameGhaz;
    }

    public void setNameGhaz(String nameGhaz) {
        this.nameGhaz = nameGhaz;
    }

    public long getIdGhaza() {
        return idGhaza;
    }

    public void setIdGhaza(long idGhaza) {
        this.idGhaza = idGhaza;
    }
}
