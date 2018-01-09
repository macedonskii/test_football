package com.mad.footballtest.mvp.screens.leagueslist;

import android.os.Parcelable;

import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.view.View;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public interface Contract {
    interface LeaguesListView extends View{
        void showLeagueDetailsActivity(LeagueItem item);

        void setItems(List<LeagueItem> leagueItems, Parcelable savedInstanceState);
    }
    interface LeaguesListPresenter extends Presenter, LeaguesAdapter.ClickListener {
        void onCreate(Parcelable parcelable);

        @Override
        void onClickItem(LeagueItem item);
    }
}
