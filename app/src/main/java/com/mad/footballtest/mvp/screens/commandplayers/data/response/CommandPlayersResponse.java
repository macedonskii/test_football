package com.mad.footballtest.mvp.screens.commandplayers.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mad on 04.01.2018.
 */

public class CommandPlayersResponse {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("players")
    @Expose
    private List<CommandPlayer> players = null;

    public List<CommandPlayer> getPlayers() {
        return players;
    }
}
