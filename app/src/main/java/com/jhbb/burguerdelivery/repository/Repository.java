package com.jhbb.burguerdelivery.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.models.IngredientModel;
import com.jhbb.burguerdelivery.services.BurguerService;
import com.jhbb.burguerdelivery.services.IngredientService;
import com.jhbb.burguerdelivery.services.OrderService;
import com.jhbb.burguerdelivery.services.SaleService;
import com.jhbb.burguerdelivery.utils.BurgerUtils;

import java.text.NumberFormat;
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

    private final MutableLiveData<List<BurgerModel>> burgerObservable = new MutableLiveData<>();

    private List<BurgerModel> cachedBurgers;

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

    public LiveData<List<BurgerModel>> getBurgerLiveData() {
        return burgerObservable;
    }

    public void loadBurgers() {
        burguerService.getBurgers().enqueue(new Callback<BurgerModel[]>() {
            @Override
            public void onResponse(Call<BurgerModel[]> call, Response<BurgerModel[]> response) {
                cachedBurgers = Arrays.asList(response.body());

                Log.d(TAG, "onResponse: returned " + cachedBurgers.size());

                for (BurgerModel burger: cachedBurgers) {
                    String formattedText = BurgerUtils.getFormattedIngredientsList(burger.getIngredients());
                    double price = BurgerUtils.getBurgerPrice(burger.getIngredients());

                    burger.setIngredientsList(formattedText);
                    burger.setPrice(price);
                }

                burgerObservable.setValue(cachedBurgers);
            }

            @Override
            public void onFailure(Call<BurgerModel[]> call, Throwable t) {
                Log.e(TAG, "onFailure: t", t);

                burgerObservable.setValue(null);
            }
        });
    }
}
