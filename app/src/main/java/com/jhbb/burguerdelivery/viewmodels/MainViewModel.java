package com.jhbb.burguerdelivery.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.jhbb.burguerdelivery.models.BurguerModel;
import com.jhbb.burguerdelivery.repository.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<BurguerModel>> burguerLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<BurguerModel>> getBurguerObservable() {
        if (burguerLiveData == null) {
            burguerLiveData = new MutableLiveData<>();
        }

        return burguerLiveData;
    }

    public void loadBurguer() {
        Repository.getInstance(getApplication()).loadBurguers();
    }
}