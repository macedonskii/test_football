package com.mad.footballtest.mvp.screens.leagueslist;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;

import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ActivityLeaguesListBinding;
import com.mad.footballtest.mvp.screens.leagueprofile.LeagueProfileActivity;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.view.AbstractActivity;

import java.util.List;

public class LeaguesListActivity extends AbstractActivity implements Contract.LeaguesListView {
    private static final String TAG_SCROLL = "SCROLL_POSITION";
    private Contract.LeaguesListPresenter mPresenter = new LeaguesListPresenter(this);
    private ActivityLeaguesListBinding mBinding;
    private LeaguesAdapter mLeaguesAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_leagues_list);
        mLeaguesAdapter = new LeaguesAdapter(mPresenter);
        mBinding.rvLeagues.setAdapter(mLeaguesAdapter);
        mLayoutManager = new LinearLayoutManager(null);
        mBinding.rvLeagues.setLayoutManager(mLayoutManager);
        mPresenter.onCreate(savedInstanceState != null && savedInstanceState.containsKey(TAG_SCROLL) ? savedInstanceState.getParcelable(TAG_SCROLL) : null);
    }

    @Override
    public void showLeagueDetailsActivity(LeagueItem item) {
        startActivity(LeagueProfileActivity.getIntent(this, item));
    }

    @Override
    public void setItems(List<LeagueItem> leagueItems, Parcelable savedInstanceState) {
        mLeaguesAdapter.setItems(leagueItems);
        if (savedInstanceState == null) {
            return;
        }
        mLayoutManager.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(TAG_SCROLL, mLayoutManager.onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }

    @Override
    public Contract.LeaguesListPresenter getPresenter() {
        return mPresenter;
    }
}
