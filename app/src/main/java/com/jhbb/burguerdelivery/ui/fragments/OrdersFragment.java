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
import com.jhbb.burguerdelivery.databinding.FragmentOrdersBinding;
import com.jhbb.burguerdelivery.models.OrderModel;
import com.jhbb.burguerdelivery.ui.adapters.OrdersAdapter;
import com.jhbb.burguerdelivery.viewmodels.OrderViewModel;

import java.util.List;

public class OrdersFragment extends Fragment {

    private FragmentOrdersBinding mBinding;
    private OrderViewModel mViewModel;
    private OrdersAdapter mOrdersAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);

        mOrdersAdapter = new OrdersAdapter();
        mBinding.rvOrdersList.setAdapter(mOrdersAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(OrderViewModel.class);
        mViewModel.getOrderObservable().observe(getViewLifecycleOwner(), new Observer<List<OrderModel>>() {
            @Override
            public void onChanged(@Nullable List<OrderModel> ordersList) {
                if (ordersList != null && ordersList.size() > 0) {
                    mBinding.rvOrdersList.setVisibility(View.VISIBLE);
                    mBinding.txtEmptyOrders.setVisibility(View.GONE);
                    mOrdersAdapter.setDataSet(ordersList);
                } else {
                    mBinding.rvOrdersList.setVisibility(View.GONE);
                    mBinding.txtEmptyOrders.setVisibility(View.VISIBLE);
                }
            }
        });

        mViewModel.loadOrders();
    }
}
