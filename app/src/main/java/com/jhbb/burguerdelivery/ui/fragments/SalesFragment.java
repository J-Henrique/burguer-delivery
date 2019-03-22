package com.jhbb.burguerdelivery.ui.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import com.jhbb.burguerdelivery.models.SaleModel;
import com.jhbb.burguerdelivery.ui.adapters.SalesAdapter;
import com.jhbb.burguerdelivery.viewmodels.SaleViewModel;

import java.util.List;

public class SalesFragment extends Fragment {

    private FragmentSalesBinding mBinding;
    private SalesAdapter mSalesAdapter;
    private SaleViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sales, container, false);

        mSalesAdapter = new SalesAdapter();
        mBinding.rvSalesList.setAdapter(mSalesAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(SaleViewModel.class);
        mViewModel.getSalesLiveData().observe(getViewLifecycleOwner(), new Observer<List<SaleModel>>() {
            @Override
            public void onChanged(@Nullable List<SaleModel> saleList) {
                mSalesAdapter.setDataSet(saleList);
            }
        });

        mViewModel.loadSales();
    }
}
