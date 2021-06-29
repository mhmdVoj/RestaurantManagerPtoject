package com.project.farjad.restaurantproject.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Factor.class,
                parentColumns = "id",
                childColumns = "idFactor",
                onDelete = ForeignKey.SET_NULL),
        @ForeignKey(entity = Ghaza.class,
                parentColumns = "id",
                childColumns = "idGhaza",
                onDelete = ForeignKey.RESTRICT,
                onUpdate = ForeignKey.CASCADE)}
)
public class RizFactor {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int jameFactor;
    private int tedad;
    private long idGhaza;
    private long idFactor;
    @Ignore
    private String ghazaName;
    @Ignore
    private int shomareFactor;
    @Ignore
    private int geymatGhaza;
    @Ignore
    private String urlImgGhaza;
    @Ignore
    private String noeGhaza;
    @Ignore
    private boolean factorIsPar;


    public String getGhazaName() {
        return ghazaName;
    }

    public void setGhazaName(String ghazaName) {
        this.ghazaName = ghazaName;
    }

    public int getShomareFactor() {
        return shomareFactor;
    }

    public void setShomareFactor(int shomareFactor) {
        this.shomareFactor = shomareFactor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getJameFactor() {
        return jameFactor;
    }

    public void setJameFactor(int jameFactor) {
        this.jameFactor = jameFactor;
    }

    public int getTedad() {
        return tedad;
    }

    public void setTedad(int tedad) {
        this.tedad = tedad;
    }

    public long getIdGhaza() {
        return idGhaza;
    }

    public void setIdGhaza(long idGhaza) {
        this.idGhaza = idGhaza;
    }

    public long getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(long idFactor) {
        this.idFactor = idFactor;
    }

    public int getGeymatGhaza() {
        return geymatGhaza;
    }

    public void setGeymatGhaza(int geymatGhaza) {
        this.geymatGhaza = geymatGhaza;
    }

    public String getUrlImgGhaza() {
        return urlImgGhaza;
    }

    public void setUrlImgGhaza(String urlImgGhaza) {
        this.urlImgGhaza = urlImgGhaza;
    }

    public String getNoeGhaza() {
        return noeGhaza;
    }

    public void setNoeGhaza(String noeGhaza) {
        this.noeGhaza = noeGhaza;
    }

    public boolean isFactorIsPar() {
        return factorIsPar;
    }

    public void setFactorIsPar(boolean factorIsPar) {
        this.factorIsPar = factorIsPar;
    }
}
