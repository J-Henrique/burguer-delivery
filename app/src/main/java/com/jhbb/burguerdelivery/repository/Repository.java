package com.jhbb.burguerdelivery.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.models.OrderModel;
import com.jhbb.burguerdelivery.models.SaleModel;
import com.jhbb.burguerdelivery.services.BurguerService;
import com.jhbb.burguerdelivery.services.IngredientService;
import com.jhbb.burguerdelivery.services.OrderService;
import com.jhbb.burguerdelivery.services.SaleService;
import com.jhbb.burguerdelivery.utils.BurgerUtils;

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
    private final MutableLiveData<List<OrderModel>> orderObservable = new MutableLiveData<>();
    private final MutableLiveData<List<SaleModel>> saleObservable = new MutableLiveData<>();

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
        if (cachedBurgers == null) {
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
        } else {
            burgerObservable.setValue(cachedBurgers);
        }

    }

    public LiveData<List<OrderModel>> getOrderLiveData() {
        return orderObservable;
    }

    public void sendOrder(BurgerModel burger) {
        orderService.putOrder(String.valueOf(burger.getIdLanche())).enqueue(new Callback<OrderModel>() {
            @Override
            public void onResponse(Call<OrderModel> call, Response<OrderModel> response) {
                Log.d(TAG, "onResponse: returned " + response.body());
            }

            @Override
            public void onFailure(Call<OrderModel> call, Throwable t) {
                Log.e(TAG, "onFailure: t", t);
            }
        });
    }

    public void loadOrders() {
        orderService.getOrders().enqueue(new Callback<OrderModel[]>() {
            @Override
            public void onResponse(Call<OrderModel[]> call, Response<OrderModel[]> response) {
                List<OrderModel> ordersList = Arrays.asList(response.body());

                Log.d(TAG, "onResponse: returned " + ordersList.size());

                for (OrderModel item : ordersList) {
                    BurgerModel orderBurger = new BurgerModel();

                    for (BurgerModel burger : cachedBurgers) {
                        if (Integer.parseInt(item.getIdBurger()) == burger.getIdLanche()) {
                            orderBurger = burger;
                        }
                    }

                    item.setBurger(orderBurger);
                }

                orderObservable.setValue(ordersList);
            }

            @Override
            public void onFailure(Call<OrderModel[]> call, Throwable t) {
                Log.e(TAG, "onFailure: t", t);

                orderObservable.setValue(null);
            }
        });
    }

    public LiveData<List<SaleModel>> getSaleLiveData() {
        return saleObservable;
    }

    public void loadSales() {
        saleService.getSales().enqueue(new Callback<SaleModel[]>() {
            @Override
            public void onResponse(Call<SaleModel[]> call, Response<SaleModel[]> response) {
                saleObservable.setValue(Arrays.asList(response.body()));
            }

            @Override
            public void onFailure(Call<SaleModel[]> call, Throwable t) {
                saleObservable.setValue(null);
            }
        });
    }
}
