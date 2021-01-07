package com.project.farjad.restaurantproject.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Semat {
    @PrimaryKey(autoGenerate = true) private long id;
    private String name;
    private int imgResource;

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
}
