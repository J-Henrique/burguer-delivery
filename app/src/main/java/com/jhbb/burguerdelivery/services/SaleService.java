package com.jhbb.burguerdelivery.services;

import com.jhbb.burguerdelivery.models.SaleModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SaleService {

    @GET("promocao")
    Call<SaleModel[]> getSales();
}
