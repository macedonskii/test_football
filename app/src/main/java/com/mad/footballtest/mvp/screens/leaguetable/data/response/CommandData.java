
package com.mad.footballtest.mvp.screens.leaguetable.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommandData {

    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("position")
    @Expose
    private int position;
    @SerializedName("teamName")
    @Expose
    private String teamName;
    @SerializedName("crestURI")
    @Expose
    private Object crestURI;
    @SerializedName("playedGames")
    @Expose
    private int playedGames;
    @SerializedName("points")
    @Expose
    private int points;
    @SerializedName("goals")
    @Expose
    private int goals;
    @SerializedName("goalsAgainst")
    @Expose
    private int goalsAgainst;
    @SerializedName("goalDifference")
    @Expose
    private int goalDifference;
    @SerializedName("wins")
    @Expose
    private int wins;
    @SerializedName("draws")
    @Expose
    private int draws;
    @SerializedName("losses")
    @Expose
    private int losses;
    @SerializedName("home")
    @Expose
    private Goals home;
    @SerializedName("away")
    @Expose
    private Goals away;

    public int getWins() {
        return wins;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getId(){
        String[] split = links.team.href.split("/");
        return Integer.parseInt(split[split.length - 1]);
    }

    private class Links {
        @SerializedName("team")
        @Expose
        public Team team;

    }

    private class Team {

        @SerializedName("href")
        @Expose
        public String href;

    }

}
