package com.mad.footballtest.mvp.screens.commandplayers;

import android.os.Parcelable;

import com.mad.footballtest.R;
import com.mad.footballtest.mvp.presenter.AbstractPresenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by mad on 03.01.2018.
 */

public class CommandPlayersPresenter extends AbstractPresenter implements Contract.CommandPlayersPresenter {

    private Contract.CommandPlayersView mView;

    public CommandPlayersPresenter(Contract.CommandPlayersView view) {
        mView = view;
    }

    @Override
    public void onCreate(Parcelable parcelable, int commandId) {
        Disposable subscribe = mModel.loadCommandPlayers(commandId).subscribe(players -> {
            if (players.size() == 0) {
                mView.showMessage(R.string.command_players_error_empty_list);
                mView.closeActivity();
                return;
            }
            mView.showPlayers(players, parcelable);
        }, mView::onError);
        mCompositeDisposable.add(subscribe);
    }



}
