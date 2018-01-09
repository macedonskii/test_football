package com.mad.footballtest.mvp.screens.leagueslist.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by mad on 03.01.2018.
 */

public class LeagueItem extends RealmObject {

    private int mId;
    private String mCaption;
    private String mLeagueName;
    private String mYear;
    private int mCurrentMatchday;
    private int mNumberOfMatchdays;
    private int mNumberOfTeams;
    private int mNumberOfGames;

    public LeagueItem() {
    }

    public LeagueItem(int id, String caption, String leagueName, String year, int currentMatchday, int numberOfMatchdays, int numberOfTeams, int numberOfGames) {
        mId = id;
        mCaption = caption;
        mLeagueName = leagueName;
        mYear = year;
        mCurrentMatchday = currentMatchday;
        mNumberOfMatchdays = numberOfMatchdays;
        mNumberOfTeams = numberOfTeams;
        mNumberOfGames = numberOfGames;
    }

    public String getCaption() {
        return mCaption;
    }

    public String getLeagueName() {
        return mLeagueName;
    }

    public int getId() {
        return mId;
    }

    public String getYear() {
        return mYear;
    }

    public int getCurrentMatchday() {
        return mCurrentMatchday;
    }

    public int getNumberOfMatchdays() {
        return mNumberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return mNumberOfTeams;
    }

    public int getNumberOfGames() {
        return mNumberOfGames;
    }
}
