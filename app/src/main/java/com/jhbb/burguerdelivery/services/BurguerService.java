package com.jhbb.burguerdelivery.services;

import com.jhbb.burguerdelivery.models.BurguerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BurguerService {

    @GET("lanche")
    Call<BurguerModel[]> getBurguers();

    @GET("lanche/{id_lanche}")
    Call<BurguerModel> getBurguerById(@Path("id_lanche") String idLanche);
}
