package com.mad.footballtest.mvp.screens.commandplayers.data;

import io.realm.RealmObject;

/**
 * Created by mad on 03.01.2018.
 */

public class Player extends RealmObject{
    private String name;
    private String position;

    public Player() {
    }

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
