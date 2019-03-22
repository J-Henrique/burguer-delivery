package com.jhbb.burguerdelivery.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.OrderCardBinding;
import com.jhbb.burguerdelivery.models.OrderModel;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {

    private List<OrderModel> mDataSet;

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        OrderCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.order_card,
                viewGroup,
                false);

        return new OrdersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder viewHolder, int i) {
        final OrderModel order = mDataSet.get(i);

        viewHolder.bind(order);
    }

    @Override
    public int getItemCount() {
        return mDataSet != null ? mDataSet.size() : 0;
    }

    public void setDataSet(List<OrderModel> ordersList) {
        mDataSet = ordersList;
        notifyDataSetChanged();
    }

    public class OrdersViewHolder extends RecyclerView.ViewHolder {

        private final OrderCardBinding mBinding;

        public OrdersViewHolder(OrderCardBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(OrderModel order) {
            mBinding.setOrder(order);
            mBinding.executePendingBindings();
        }
    }
}
