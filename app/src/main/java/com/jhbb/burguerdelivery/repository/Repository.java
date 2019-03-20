package com.jhbb.burguerdelivery.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.models.BurguerModel;
import com.jhbb.burguerdelivery.services.BurguerService;
import com.jhbb.burguerdelivery.services.IngredientService;
import com.jhbb.burguerdelivery.services.OrderService;
import com.jhbb.burguerdelivery.services.SaleService;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final String TAG = Repository.class.getSimpleName();

    private static Repository sRepository;

    private final BurguerService burguerService;
    private final IngredientService ingredientService;
    private final OrderService orderService;
    private final SaleService saleService;

    private final MutableLiveData<List<BurguerModel>> burguerObservable = new MutableLiveData<>();

    private Repository(final Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getResources().getString(R.string.apiUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        burguerService = retrofit.create(BurguerService.class);
        ingredientService = retrofit.create(IngredientService.class);
        orderService = retrofit.create(OrderService.class);
        saleService = retrofit.create(SaleService.class);
    }

    public static Repository getInstance(final Context context) {
        if (sRepository == null) {
            synchronized (Repository.class) {
                if (sRepository == null) {
                    sRepository = new Repository(context);
                }
            }
        }
        return sRepository;
    }

    public void loadBurguers() {
        burguerService.getBurguers().enqueue(new Callback<BurguerModel[]>() {
            @Override
            public void onResponse(Call<BurguerModel[]> call, Response<BurguerModel[]> response) {
                Log.d(TAG, "onResponse: returned " + Arrays.asList(response.body()).size());

                burguerObservable.setValue(Arrays.asList(response.body()));
            }

            @Override
            public void onFailure(Call<BurguerModel[]> call, Throwable t) {
                Log.e(TAG, "onFailure: t", t);

                burguerObservable.setValue(null);
            }
        });
    }
}