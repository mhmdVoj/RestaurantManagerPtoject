package com.project.farjad.restaurantproject.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Personel {
    @PrimaryKey(autoGenerate =true) private long id;
    private String name;
    private String shomareTel;
    private String tarikhVorol;
    private String address;
    private long id_semat;

    @Ignore private String semat;
    @Ignore private int imgSemat;

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

    public String getTarikhVorol() {
        return tarikhVorol;
    }

    public void setTarikhVorol(String tarikhVorol) {
        this.tarikhVorol = tarikhVorol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId_semat() {
        return id_semat;
    }

    public void setId_semat(long id_semat) {
        this.id_semat = id_semat;
    }

    public String getSemat() {
        return semat;
    }

    public void setSemat(String semat) {
        this.semat = semat;
    }

    public int getImgSemat() {
        return imgSemat;
    }

    public void setImgSemat(int imgSemat) {
        this.imgSemat = imgSemat;
    }
}
