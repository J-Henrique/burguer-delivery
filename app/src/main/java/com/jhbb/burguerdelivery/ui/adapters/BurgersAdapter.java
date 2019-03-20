package com.jhbb.burguerdelivery.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.BurgerCardBinding;
import com.jhbb.burguerdelivery.models.BurgerModel;

import java.util.List;

public class BurgersAdapter extends RecyclerView.Adapter<BurgersAdapter.BurguersViewHolder> {

    private List<BurgerModel> mDataSet;

    @NonNull
    @Override
    public BurguersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BurgerCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.burger_card,
                viewGroup,
                false);

        return new BurguersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BurguersViewHolder viewHolder, int i) {
        final BurgerModel burguer = mDataSet.get(i);

        viewHolder.bind(burguer);
    }

    @Override
    public int getItemCount() {
        return mDataSet != null ? mDataSet.size() : 0;
    }

    public void setDataSet(List<BurgerModel> burguersList) {
        mDataSet = burguersList;
        notifyDataSetChanged();
    }

    public class BurguersViewHolder extends RecyclerView.ViewHolder {

        private final BurgerCardBinding mBinding;

        public BurguersViewHolder(BurgerCardBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(BurgerModel burguer) {
            mBinding.setBurger(burguer);
        }
    }
}
