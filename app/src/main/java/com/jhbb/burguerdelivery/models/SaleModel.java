package com.jhbb.burguerdelivery.models;

public class SaleModel {

    private int idSale;
    private String name;
    private String description;

    public SaleModel() {
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SaleModel{" +
                "idSale=" + idSale +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
