package com.jhbb.burguerdelivery.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.repository.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<BurgerModel>> burgerLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<BurgerModel>> getBurgerObservable() {
        if (burgerLiveData == null) {
            burgerLiveData = Repository.getInstance(getApplication()).getBurgerLiveData();
        }

        return burgerLiveData;
    }

    public void loadBurgers() {
        Repository.getInstance(getApplication()).loadBurgers();
    }
}
