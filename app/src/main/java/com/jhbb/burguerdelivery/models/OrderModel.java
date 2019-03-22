package com.jhbb.burguerdelivery.models;

import com.google.gson.annotations.SerializedName;

public class OrderModel {

    private int id;

    @SerializedName("id_sandwich")
    private String idBurger;

    private BurgerModel burger;

    public OrderModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdBurger() {
        return idBurger;
    }

    public void setIdBurger(String idBurger) {
        this.idBurger = idBurger;
    }

    public BurgerModel getBurger() {
        return burger;
    }

    public void setBurger(BurgerModel burger) {
        this.burger = burger;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", idBurger='" + idBurger + '\'' +
                ", burger=" + burger +
                '}';
    }
}
