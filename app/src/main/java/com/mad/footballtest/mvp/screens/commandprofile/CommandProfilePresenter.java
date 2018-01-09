package com.mad.footballtest.mvp.screens.commandprofile;

import android.os.Bundle;

import com.mad.footballtest.mvp.presenter.AbstractPresenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by mad on 03.01.2018.
 */

public class CommandProfilePresenter extends AbstractPresenter implements Contract.CommandProfilePresenter {

    private Contract.CommandProfileView mView;
    private int mCommandId;

    public CommandProfilePresenter(Contract.CommandProfileView view) {
        mView = view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState, int commandId) {
        mCommandId = commandId;
        Disposable subscribe = mModel.getCommandData(commandId).subscribe(mView::showCommandData, mView::onError);
        mCompositeDisposable.add(subscribe);
    }

    @Override
    public void onClickShowPlayers() {
        mView.showPlayersActivity(mCommandId);
    }
}
