package com.jhbb.burguerdelivery.services;

import com.jhbb.burguerdelivery.models.IngredientModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IngredientService {

    @GET("ingrediente")
    Call<IngredientModel[]> getIngredients();

    @GET("ingrediente/{id_lanche}")
    Call<IngredientModel> getIngredientById(@Path("id_lanche") String idLanche);
}
