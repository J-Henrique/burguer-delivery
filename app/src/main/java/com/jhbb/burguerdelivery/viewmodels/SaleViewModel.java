package com.jhbb.burguerdelivery.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jhbb.burguerdelivery.models.SaleModel;
import com.jhbb.burguerdelivery.repository.Repository;

import java.util.List;

public class SaleViewModel extends AndroidViewModel {

    private LiveData<List<SaleModel>> salesLiveData;

    public SaleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<SaleModel>> getSalesLiveData() {
        if (salesLiveData == null) {
            salesLiveData = Repository.getInstance(getApplication()).getSaleLiveData();
        }

        return salesLiveData;
    }

    public void loadSales() {
        Repository.getInstance(getApplication()).loadSales();
    }
}
