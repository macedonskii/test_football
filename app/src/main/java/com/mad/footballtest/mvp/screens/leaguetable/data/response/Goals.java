
package com.mad.footballtest.mvp.screens.leaguetable.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goals {

    @SerializedName("goals")
    @Expose
    public int goals;
    @SerializedName("goalsAgainst")
    @Expose
    public int goalsAgainst;
    @SerializedName("wins")
    @Expose
    public int wins;
    @SerializedName("draws")
    @Expose
    public int draws;
    @SerializedName("losses")
    @Expose
    public int losses;

}
