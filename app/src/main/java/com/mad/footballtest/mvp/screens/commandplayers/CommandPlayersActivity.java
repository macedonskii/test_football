package com.mad.footballtest.mvp.screens.commandplayers;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ActivityCommandPlayersBinding;
import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.commandplayers.data.Player;
import com.mad.footballtest.mvp.view.AbstractActivity;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public class CommandPlayersActivity extends AbstractActivity implements Contract.CommandPlayersView {

    private static final String TAG_DATA = "data";
    private static final String TAG_SCROLL = "scroll";
    private Contract.CommandPlayersPresenter mPresenter = new CommandPlayersPresenter(this);
    private ActivityCommandPlayersBinding mBinding;
    private LeaguePlayersAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    public static Intent getIntent(Context context, int commandId) {
        return new Intent(context, CommandPlayersActivity.class).putExtra(TAG_DATA, commandId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_command_players);
        showBackButton();
        mLayoutManager = new LinearLayoutManager(null);
        mBinding.rvPlayers.setLayoutManager(mLayoutManager);
        mAdapter = new LeaguePlayersAdapter();
        mBinding.rvPlayers.setAdapter(mAdapter);

        mPresenter.onCreate(savedInstanceState != null && savedInstanceState.containsKey(TAG_SCROLL) ? savedInstanceState.getParcelable(TAG_SCROLL) : null,
                getIntent().getIntExtra(TAG_DATA, 0));
    }


    @Override
    public void showPlayers(List<Player> players, Parcelable parcelable) {
        mAdapter.setItems(players);
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
    public void closeActivity() {
        finish();
    }
}
