package com.jhbb.burguerdelivery.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.FragmentSalesBinding;

public class SalesFragment extends Fragment {

    private FragmentSalesBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sales, container, false);

        return mBinding.getRoot();
    }
}
