
package com.jhbb.burguerdelivery.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.ActivityMainBinding;
import com.jhbb.burguerdelivery.ui.adapters.BurgerDeliveryPagerAdapter;
import com.jhbb.burguerdelivery.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(mViewModel);

        BurgerDeliveryPagerAdapter pagerAdapter = new BurgerDeliveryPagerAdapter(getSupportFragmentManager());
        mBinding.viewPager.setAdapter(pagerAdapter);

        setupTabLayout();
    }

    private void setupTabLayout() {
        TabLayout tabLayout = mBinding.tabLayout;
        tabLayout.setupWithViewPager(mBinding.viewPager);

        // Burgers tab
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_hamburguer);
        tabLayout.getTabAt(0).setText(R.string.tab_item_burgers);

        // Sales tab
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_sales);
        tabLayout.getTabAt(1).setText(R.string.tab_item_sales);

        // Orders tab
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_shopping_cart);
        tabLayout.getTabAt(2).setText(R.string.tab_item_orders);
    }
}
