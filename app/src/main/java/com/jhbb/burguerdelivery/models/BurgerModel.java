package com.jhbb.burguerdelivery.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Arrays;
import java.util.List;

@Parcel
public class BurgerModel {

    @SerializedName("id")
    private int idLanche;

    private String name;

    @SerializedName("ingredients")
    private List<IngredientModel> ingredients;

    private String ingredientsList;

    private double price;

    private String description;

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

    public List<IngredientModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientModel> ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", description='" + description + '\'' +
                ", ingredients=" + Arrays.toString(ingredients.toArray()) +
                ", totalPrice=" + price +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
