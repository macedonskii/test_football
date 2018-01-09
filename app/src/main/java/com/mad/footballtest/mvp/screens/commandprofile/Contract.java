package com.mad.footballtest.mvp.screens.commandprofile;

import android.os.Bundle;

import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.commandprofile.data.Command;
import com.mad.footballtest.mvp.view.View;

/**
 * Created by mad on 03.01.2018.
 */

public interface Contract {
    interface CommandProfileView extends View{
        void showCommandData(Command command);

        void showPlayersActivity(int commandId);
    }
    interface CommandProfilePresenter extends Presenter{
        void onCreate(Bundle savedInstanceState, int intExtra);

        void onClickShowPlayers();

    }
}
