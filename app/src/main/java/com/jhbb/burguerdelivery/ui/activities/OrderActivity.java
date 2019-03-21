package com.jhbb.burguerdelivery.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.models.BurgerModel;

import org.parceler.Parcels;

public class OrderActivity extends AppCompatActivity {

    public static final String EXTRA_SELECTED_ITEM = "extra_selected_item";
    public static final String TAG = OrderActivity.class.getSimpleName();

    private BurgerModel burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        if (getIntent().hasExtra(EXTRA_SELECTED_ITEM)) {

            burger = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_SELECTED_ITEM));
            Log.d(TAG, "selected item: " + burger.toString());
        }
    }
}
