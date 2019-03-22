package com.jhbb.burguerdelivery.services;

import com.jhbb.burguerdelivery.models.OrderModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrderService {

    @PUT("pedido/{id_lanche}")
    Call<OrderModel> putOrder(@Path("id_lanche") String idLanche);

    @GET("pedido")
    Call<OrderModel[]> getOrders();
}
