package com.mad.footballtest.mvp.screens.leagueprofile;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ActivityLeagueDetailsBinding;
import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.screens.leaguetable.LeagueTableActivity;
import com.mad.footballtest.mvp.view.AbstractActivity;

/**
 * Created by mad on 03.01.2018.
 */

public class LeagueProfileActivity extends AbstractActivity implements Contract.LeagueProfileView {

    private static final String TAG_DATA = "DATA";
    private Contract.LeagueProfilePresenter mPresenter = new LeagueProfilePresenter(this);
    private ActivityLeagueDetailsBinding mBinding;


    public static Intent getIntent(Context context, LeagueItem item) {
        return new Intent(context, LeagueProfileActivity.class).putExtra(TAG_DATA, new Gson().toJson(item));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_league_details);
        mBinding.btnShowTable.setOnClickListener(v -> mPresenter.onClickShowTable());
        showBackButton();

        mPresenter.onCreate(new Gson().fromJson(getIntent().getExtras().getString(TAG_DATA), LeagueItem.class));

    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showItemDetails(LeagueItem item) {
        mBinding.tvCaption.setText(getString(R.string.league_profile_caption, item.getCaption()));
        mBinding.tvLeague.setText(getString(R.string.league_profile_league, item.getLeagueName()));
        mBinding.tvYear.setText(getString(R.string.league_profile_year, item.getYear()));
        mBinding.tvCurrentMatchday.setText(getString(R.string.league_profile_matchdays_current, item.getCurrentMatchday()));
        mBinding.tvCountMatchdays.setText(getString(R.string.league_profile_matchdays_count, item.getNumberOfMatchdays()));
        mBinding.tvGamesCount.setText(getString(R.string.league_profile_games_count, item.getNumberOfGames()));
    }

    @Override
    public void showTableActivity(int id) {
        startActivity(LeagueTableActivity.getIntent(this, id));
    }
}
