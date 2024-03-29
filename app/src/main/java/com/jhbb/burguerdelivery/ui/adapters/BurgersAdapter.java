package com.jhbb.burguerdelivery.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhbb.burguerdelivery.R;
import com.jhbb.burguerdelivery.databinding.BurgerCardBinding;
import com.jhbb.burguerdelivery.models.BurgerModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BurgersAdapter extends RecyclerView.Adapter<BurgersAdapter.BurgersViewHolder> {

    private List<BurgerModel> mDataSet;
    private CardClickListener mItemClick;

    public interface CardClickListener {
        void onItemClick(BurgerModel burger);
    }

    public BurgersAdapter(CardClickListener cardClickListener) {
        mItemClick = cardClickListener;
    }

    @NonNull
    @Override
    public BurgersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BurgerCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.burger_card,
                viewGroup,
                false);

        return new BurgersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgersViewHolder viewHolder, int i) {
        final BurgerModel burger = mDataSet.get(i);

        Picasso.get()
            .load(burger.getUrlImage())
            .noFade()
            .placeholder(R.drawable.ic_food)
            .into(viewHolder.mBinding.ivPicture);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClick.onItemClick(burger);
            }
        });

        viewHolder.bind(burger);
    }

    @Override
    public int getItemCount() {
        return mDataSet != null ? mDataSet.size() : 0;
    }

    public void setDataSet(List<BurgerModel> burgersList) {
        mDataSet = burgersList;
        notifyDataSetChanged();
    }

    public class BurgersViewHolder extends RecyclerView.ViewHolder {

        private final BurgerCardBinding mBinding;

        public BurgersViewHolder(BurgerCardBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(BurgerModel burger) {
            mBinding.setBurger(burger);
            mBinding.executePendingBindings();
        }
    }
}
