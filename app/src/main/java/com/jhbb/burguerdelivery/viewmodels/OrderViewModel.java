package com.jhbb.burguerdelivery.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.models.OrderModel;
import com.jhbb.burguerdelivery.repository.Repository;

public class OrderViewModel extends AndroidViewModel {

    private LiveData<OrderModel> orderLiveData;

    public OrderViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<OrderModel> getOrderObservable() {
        if (orderLiveData == null) {
            orderLiveData = Repository.getInstance(getApplication()).getOrderLiveData();
        }

        return orderLiveData;
    }

    public void sendOrder(BurgerModel burger) {
        Repository.getInstance(getApplication()).sendOrder(burger);
    }
}
