package com.jhbb.burguerdelivery.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.models.OrderModel;
import com.jhbb.burguerdelivery.repository.Repository;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {

    private LiveData<List<OrderModel>> orderLiveData;

    public OrderViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<OrderModel>> getOrderObservable() {
        if (orderLiveData == null) {
            orderLiveData = Repository.getInstance(getApplication()).getOrderLiveData();
        }

        return orderLiveData;
    }

    public void loadOrders() {
        Repository.getInstance(getApplication()).loadOrders();
    }

    public void sendOrder(BurgerModel burger) {
        Repository.getInstance(getApplication()).sendOrder(burger);
    }
}
