package com.mad.footballtest.mvp.screens.leagueprofile;

import com.mad.footballtest.mvp.presenter.AbstractPresenter;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;

/**
 * Created by mad on 03.01.2018.
 */

public class LeagueProfilePresenter extends AbstractPresenter implements Contract.LeagueProfilePresenter {

    private Contract.LeagueProfileView mView;
    private LeagueItem mLeagueItem;

    public LeagueProfilePresenter(Contract.LeagueProfileView view) {
        mView = view;
    }

    @Override
    public void onCreate(LeagueItem item) {
        mLeagueItem = item;
        mView.showItemDetails(item);
    }

    @Override
    public void onClickShowTable() {
        mView.showTableActivity(mLeagueItem.getId());
    }
}
