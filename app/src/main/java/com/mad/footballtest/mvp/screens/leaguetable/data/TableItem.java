package com.mad.footballtest.mvp.screens.leaguetable.data;

import io.realm.RealmObject;

/**
 * Created by mad on 03.01.2018.
 */

public class TableItem extends RealmObject {

    private int mId;
    private String mTeamName;
    private int mWinGames;
    private int mLooseGames;
    private int mDrawsGames;

    public TableItem() {
    }

    public TableItem(int id, String teamName, int winGames, int looseGames, int drawsGames) {
        mId = id;
        mTeamName = teamName;
        mWinGames = winGames;
        mLooseGames = looseGames;
        mDrawsGames = drawsGames;
    }

    public int getId() {
        return mId;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public int getWinGames() {
        return mWinGames;
    }

    public int getLooseGames() {
        return mLooseGames;
    }

    public int getDrawsGames() {
        return mDrawsGames;
    }
}
