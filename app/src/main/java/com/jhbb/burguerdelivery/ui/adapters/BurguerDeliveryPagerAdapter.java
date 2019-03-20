package com.jhbb.burguerdelivery.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jhbb.burguerdelivery.ui.fragments.BurguersFragment;

public class BurguerDeliveryPagerAdapter extends FragmentPagerAdapter {

    public BurguerDeliveryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new BurguersFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
