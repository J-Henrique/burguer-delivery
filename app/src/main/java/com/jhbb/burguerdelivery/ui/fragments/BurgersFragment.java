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
import com.jhbb.burguerdelivery.databinding.FragmentBurgersBinding;
import com.jhbb.burguerdelivery.models.BurgerModel;
import com.jhbb.burguerdelivery.ui.adapters.BurgersAdapter;
import com.jhbb.burguerdelivery.viewmodels.MainViewModel;

import java.util.List;

public class BurgersFragment extends Fragment {

    private FragmentBurgersBinding mBinding;
    private BurgersAdapter mBurgersAdapter;
    private MainViewModel mMainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_burgers, container, false);

        mBurgersAdapter = new BurgersAdapter();
        mBinding.rvBurguersList.setAdapter(mBurgersAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mMainViewModel.getBurgerObservable().observe(getActivity(), new Observer<List<BurgerModel>>() {
            @Override
            public void onChanged(@Nullable List<BurgerModel> burgerModels) {
                mBurgersAdapter.setDataSet(burgerModels);
            }
        });

        mMainViewModel.loadBurgers();
    }
}
