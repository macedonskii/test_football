package com.mad.footballtest.mvp.screens.commandprofile.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mad on 04.01.2018.
 */

public class Command extends RealmObject{
    @PrimaryKey
    private int mId;
    private String mName;
    private String mCode;
    private String mLogoUrl;
    private long mCreationTime;

    public Command() {
    }

    public Command(String name, String code, String logoUrl) {
        mName = name;
        mCode = code;
        mLogoUrl = logoUrl;
        mCreationTime = System.currentTimeMillis();
    }

    public String getName() {
        return mName;
    }

    public String getCode() {
        return mCode;
    }

    public String getLogoUrl() {
        return mLogoUrl;
    }

    public Command setId(int id) {
        mId = id;
        return this;
    }

    public int getId() {
        return mId;
    }

    public long getCreationTime() {
        return mCreationTime;
    }
}
