package com.mad.footballtest.mvp.screens.leaguetable;

import android.os.Parcelable;

import com.mad.footballtest.mvp.presenter.AbstractPresenter;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import io.reactivex.disposables.Disposable;

/**
 * Created by mad on 03.01.2018.
 */

public class LeagueTablePresenter extends AbstractPresenter implements Contract.LeagueTablePresenter {

    private Contract.LeagueTableView mView;

    public LeagueTablePresenter(Contract.LeagueTableView view) {
        mView = view;
    }

    @Override
    public void onCreate(int leagueId, Parcelable parcelable) {
        Disposable subscribe = mModel.getLeagueTable(leagueId).subscribe(tableItems -> mView.showItems(tableItems, parcelable), mView::onError);
        mCompositeDisposable.add(subscribe);
    }

    @Override
    public void onClick(TableItem item) {
        mView.showCommandActivity(item.getId());
    }
}
