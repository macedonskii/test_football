package com.mad.footballtest.mvp.screens.commandplayers;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ListItemPlayerBinding;
import com.mad.footballtest.mvp.screens.commandplayers.data.Player;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public class LeaguePlayersAdapter extends RecyclerView.Adapter<LeaguePlayersAdapter.PlayerHolder> {

    private List<Player> mItems;

    @Override
    public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlayerHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_player, parent, false));
    }

    @Override
    public void onBindViewHolder(PlayerHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public void setItems(List<Player> players) {
        mItems = players;
        notifyDataSetChanged();
    }

    protected static class PlayerHolder extends RecyclerView.ViewHolder{

        private ListItemPlayerBinding mBinding;

        public PlayerHolder(ListItemPlayerBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Player player) {
            mBinding.tvHeader.setText(player.getName());
            mBinding.tvFooter.setText(player.getPosition());
        }
    }


}
