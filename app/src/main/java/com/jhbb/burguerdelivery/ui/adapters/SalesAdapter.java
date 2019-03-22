package com.jhbb.burguerdelivery.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.SaleCardBinding;
import com.jhbb.burguerdelivery.models.SaleModel;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SalesViewHolder> {

    private List<SaleModel> mDataSet;

    @NonNull
    @Override
    public SalesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SaleCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.sale_card,
                viewGroup,
                false);

        return new SalesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesViewHolder viewHolder, int i) {
        final SaleModel sale = mDataSet.get(i);

        viewHolder.bind(sale);
    }

    @Override
    public int getItemCount() {
        return mDataSet != null ? mDataSet.size() : 0;
    }

    public void setDataSet(List<SaleModel> ordersList) {
        mDataSet = ordersList;
        notifyDataSetChanged();
    }

    public class SalesViewHolder extends RecyclerView.ViewHolder {

        private final SaleCardBinding mBinding;

        public SalesViewHolder(SaleCardBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(SaleModel sale) {
            mBinding.setSale(sale);
            mBinding.executePendingBindings();
        }
    }
}
