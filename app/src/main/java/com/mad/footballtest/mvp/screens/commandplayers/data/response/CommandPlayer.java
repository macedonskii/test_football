package com.mad.footballtest.mvp.screens.commandplayers.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mad on 03.01.2018.
 */

public class CommandPlayer {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("jerseyNumber")
    @Expose
    private int jerseyNumber;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("contractUntil")
    @Expose
    private String contractUntil;
    @SerializedName("marketValue")
    @Expose
    private Object marketValue;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
