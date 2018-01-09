package com.mad.footballtest.mvp.screens.commandplayers;

import android.os.Parcelable;

import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.commandplayers.data.Player;
import com.mad.footballtest.mvp.view.View;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public interface Contract {
    interface CommandPlayersView extends View{
        void showPlayers(List<Player> players, Parcelable parcelable);

        void closeActivity();


    }
    interface CommandPlayersPresenter extends Presenter{
        void onCreate(Parcelable parcelable, int intExtra);
    }
}
