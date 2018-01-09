
package com.mad.footballtest.mvp.screens.leaguetable.data.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueTableResponse {

    @SerializedName("leagueCaption")
    @Expose
    private String leagueCaption;
    @SerializedName("matchday")
    @Expose
    private int matchday;
    @SerializedName("standing")
    @Expose
    private List<CommandData> mCommandData = null;

    public List<CommandData> getCommandData() {
        return mCommandData;
    }
}
