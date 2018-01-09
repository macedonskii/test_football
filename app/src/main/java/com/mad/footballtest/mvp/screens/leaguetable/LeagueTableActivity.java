package com.mad.footballtest.mvp.screens.leaguetable;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ActivityLeagueTableBinding;
import com.mad.footballtest.mvp.screens.commandprofile.CommandProfileActivity;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;
import com.mad.footballtest.mvp.view.AbstractActivity;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public class LeagueTableActivity extends AbstractActivity implements Contract.LeagueTableView {

    private static final String TAG_ID = "id";
    private static final String TAG_SCROLL = "scroll";
    private Contract.LeagueTablePresenter mPresenter = new LeagueTablePresenter(this);
    private ActivityLeagueTableBinding mBinding;
    private LeagueTableAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public Contract.LeagueTablePresenter getPresenter() {
        return mPresenter;
    }

    public static Intent getIntent(Context context, int id) {
        return new Intent(context, LeagueTableActivity.class).putExtra(TAG_ID, id);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_league_table);
        mLayoutManager = new LinearLayoutManager(null);
        mBinding.rvCommands.setLayoutManager(mLayoutManager);
        mAdapter = new LeagueTableAdapter(mPresenter);
        mBinding.rvCommands.setAdapter(mAdapter);
        showBackButton();

        mPresenter.onCreate(getIntent().getExtras().getInt(TAG_ID),
                savedInstanceState != null && savedInstanceState.containsKey(TAG_SCROLL) ? savedInstanceState.getParcelable(TAG_SCROLL) : null);
    }

    @Override
    public void showItems(List<TableItem> tableItems, Parcelable parcelable) {
        mAdapter.setItems(tableItems);
        if (parcelable == null) {
            return;
        }
        mLayoutManager.onRestoreInstanceState(parcelable);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(TAG_SCROLL, mLayoutManager.onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showCommandActivity(int id) {
        startActivity(CommandProfileActivity.getIntent(this, id));
    }
}
