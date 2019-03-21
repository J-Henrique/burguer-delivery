package com.jhbb.burguerdelivery.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.ActivityOrderBinding;
import com.jhbb.burguerdelivery.models.BurgerModel;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class OrderActivity extends AppCompatActivity {

    public static final String EXTRA_SELECTED_ITEM = "extra_selected_item";
    public static final String TAG = OrderActivity.class.getSimpleName();

    private BurgerModel burger;
    private ActivityOrderBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_order);

        if (getIntent().hasExtra(EXTRA_SELECTED_ITEM)) {

            burger = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_SELECTED_ITEM));
            Log.d(TAG, "selected item: " + burger.toString());

            mBinding.setBurger(burger);
            setupImage(burger);
        }
    }

    private void setupImage(BurgerModel burger) {
        Picasso.get()
            .load(burger.getUrlImage())
            .placeholder(R.drawable.ic_food)
            .resize(360, 360)
            .into(mBinding.ivPicture);
    }

    public void backClick(View view) {
        onBackPressed();
    }
}
