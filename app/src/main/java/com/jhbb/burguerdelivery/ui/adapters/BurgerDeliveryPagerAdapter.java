package com.jhbb.burguerdelivery.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jhbb.burguerdelivery.ui.fragments.BurgersFragment;
import com.jhbb.burguerdelivery.ui.fragments.OrdersFragment;
import com.jhbb.burguerdelivery.ui.fragments.SalesFragment;

public class BurgerDeliveryPagerAdapter extends FragmentPagerAdapter {

    public BurgerDeliveryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new BurgersFragment();
        } else if (i == 1) {
            return new SalesFragment();
        } else {
            return new OrdersFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
