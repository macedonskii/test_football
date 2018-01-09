package com.mad.footballtest.mvp.screens.leagueslist;

import android.os.Parcelable;

import com.mad.footballtest.mvp.presenter.AbstractPresenter;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;

import io.reactivex.disposables.Disposable;

/**
 * Created by mad on 03.01.2018.
 */

public class LeaguesListPresenter extends AbstractPresenter implements Contract.LeaguesListPresenter {


    private Contract.LeaguesListView mView;

    public LeaguesListPresenter(Contract.LeaguesListView view) {
        mView = view;
    }

    @Override
    public void onCreate(Parcelable parcelable) {
        Disposable subscribe = mModel.loadLeagues().subscribe(leagueItems -> mView.setItems(leagueItems, parcelable), mView::onError);
        mCompositeDisposable.add(subscribe);
    }

    @Override
    public void onClickItem(LeagueItem item) {
        mView.showLeagueDetailsActivity(item);
    }
}
