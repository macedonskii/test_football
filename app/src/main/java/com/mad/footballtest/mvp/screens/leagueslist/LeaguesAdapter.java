package com.mad.footballtest.mvp.screens.leagueslist;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ListItemLeagueBinding;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.LeagueHolder> {

    private List<LeagueItem> mItems;
    private ClickListener mListener;

    public LeaguesAdapter(ClickListener listener) {
        mListener = listener;
    }

    @Override
    public LeagueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeagueHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_league,parent, false),mListener);
    }

    @Override
    public void onBindViewHolder(LeagueHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public void setItems(List<LeagueItem> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    protected static class LeagueHolder extends RecyclerView.ViewHolder {

        private ListItemLeagueBinding mBinding;
        private ClickListener mClickListener;

        public LeagueHolder(ListItemLeagueBinding binding, ClickListener clickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mClickListener = clickListener;
        }

        public void bind(LeagueItem leagueItem) {
            mBinding.tvName.setText(leagueItem.getCaption());
            mBinding.tvLeague.setText(leagueItem.getLeagueName());
            mBinding.vgRoot.setOnClickListener(v -> mClickListener.onClickItem(leagueItem));
        }
    }
    interface ClickListener{
        void onClickItem(LeagueItem item);
    }
}
