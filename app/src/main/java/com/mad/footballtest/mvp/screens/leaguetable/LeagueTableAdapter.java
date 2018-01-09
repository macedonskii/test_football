package com.mad.footballtest.mvp.screens.leaguetable;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ListItemTableBinding;
import com.mad.footballtest.mvp.screens.commandplayers.LeaguePlayersAdapter;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.CommandHolder> {

    private List<TableItem> mItems;
    private ClickListener mListener;

    public LeagueTableAdapter(ClickListener listener) {
        mListener = listener;
    }

    @Override
    public CommandHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommandHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_table, parent, false));
    }

    @Override
    public void onBindViewHolder(CommandHolder holder, int position) {
        holder.bind(mItems.get(position), mListener);
    }

    public void setItems(List<TableItem> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    protected static class CommandHolder extends RecyclerView.ViewHolder{

        private ListItemTableBinding mBinding;

        public CommandHolder(ListItemTableBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(TableItem tableItem, ClickListener listener) {
            mBinding.vgRoot.setOnClickListener(v -> listener.onClick(tableItem));
            mBinding.tvHeader.setText(tableItem.getTeamName());
            mBinding.tvFooter.setText(mBinding.getRoot().getContext().getString(R.string.matches_statistic,
                    tableItem.getWinGames(), tableItem.getDrawsGames(), tableItem.getLooseGames()));
        }
    }
    interface ClickListener{
        void onClick(TableItem item);
    }
}
