package com.jhbb.burguerdelivery.services;

import com.jhbb.burguerdelivery.models.BurgerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BurguerService {

    @GET("lanche")
    Call<BurgerModel[]> getBurgers();

    @GET("lanche/{id_lanche}")
    Call<BurgerModel> getBurgerById(@Path("id_lanche") String idLanche);
}
