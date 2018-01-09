package com.mad.footballtest.mvp.screens.leagueslist.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mad on 04.01.2018.
 */

public class LeagueItemResponse {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("league")
    @Expose
    private String league;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("currentMatchday")
    @Expose
    private int currentMatchday;
    @SerializedName("numberOfMatchdays")
    @Expose
    private int numberOfMatchdays;
    @SerializedName("numberOfTeams")
    @Expose
    private int numberOfTeams;
    @SerializedName("numberOfGames")
    @Expose
    private int numberOfGames;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getLeague() {
        return league;
    }

    public String getYear() {
        return year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }
}
