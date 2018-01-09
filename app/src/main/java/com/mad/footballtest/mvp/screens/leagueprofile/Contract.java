package com.mad.footballtest.mvp.screens.leagueprofile;

import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.view.View;

/**
 * Created by mad on 03.01.2018.
 */

public interface Contract {
    interface LeagueProfileView extends View{
        void showItemDetails(LeagueItem item);

        void showTableActivity(int id);
    }
    interface LeagueProfilePresenter extends Presenter{
        void onCreate(LeagueItem leagueItem);

        void onClickShowTable();
    }
}
