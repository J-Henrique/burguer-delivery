package com.jhbb.burguerdelivery.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class BurgerModel {

    @SerializedName("id")
    private int idLanche;

    private String name;

    @SerializedName("ingredients")
    private int[] idIngredients;

    @SerializedName("image")
    private String urlImage;

    public BurgerModel() {
    }

    public int getIdLanche() {
        return idLanche;
    }

    public void setIdLanche(int idLanche) {
        this.idLanche = idLanche;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIdIngredients() {
        return idIngredients;
    }

    public void setIdIngredients(int[] idIngredients) {
        this.idIngredients = idIngredients;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "BurgerModel{" +
                "idLanche=" + idLanche +
                ", name='" + name + '\'' +
                ", idIngredients=" + Arrays.toString(idIngredients) +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}