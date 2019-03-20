package com.jhbb.burguerdelivery.models;

public class IngredientModel {

    private int idIngredient;
    private String name;
    private Long price;
    private String urlImage;

    public IngredientModel() {
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "IngredientModel{" +
                "idIngredient=" + idIngredient +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
