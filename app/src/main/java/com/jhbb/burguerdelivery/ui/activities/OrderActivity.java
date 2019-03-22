package com.jhbb.burguerdelivery.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.ActivityOrderBinding;
import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.viewmodels.OrderViewModel;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class OrderActivity extends AppCompatActivity {

    public static final String EXTRA_SELECTED_ITEM = "extra_selected_item";
    public static final String TAG = OrderActivity.class.getSimpleName();

    private BurgerModel mBurger;
    private ActivityOrderBinding mBinding;
    private OrderViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_order);

        if (getIntent().hasExtra(EXTRA_SELECTED_ITEM)) {

            mBurger = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_SELECTED_ITEM));
            Log.d(TAG, "selected item: " + mBurger.toString());

            mBinding.setBurger(mBurger);
            setupImage(mBurger);
        }

        mViewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
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

    public void confirmClick(View view) {
        mViewModel.sendOrder(mBurger);

        Toast.makeText(OrderActivity.this, getResources().getText(R.string.msg_order), Toast.LENGTH_LONG).show();
        finish();
    }
}
