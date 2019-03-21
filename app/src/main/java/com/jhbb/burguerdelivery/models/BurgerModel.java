package com.jhbb.burguerdelivery.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class BurgerModel {

    @SerializedName("id")
    private int idLanche;

    private String name;

    @SerializedName("ingredients")
    private List<IngredientModel> ingredients;

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

    public List<IngredientModel> getIdIngredients() {
        return ingredients;
    }

    public void setIdIngredients(List<IngredientModel> ingredients) {
        this.ingredients = ingredients;
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
                ", ingredients=" + Arrays.toString(ingredients.toArray()) +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
