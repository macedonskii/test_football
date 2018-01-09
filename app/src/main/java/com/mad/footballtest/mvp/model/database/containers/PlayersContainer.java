package com.mad.footballtest.mvp.model.database.containers;

import com.mad.footballtest.mvp.screens.commandplayers.data.Player;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mad on 09.01.2018.
 */

public class PlayersContainer extends RealmObject implements ListContainer {

    @PrimaryKey
    protected int mId;
    private Long mCreationTime = System.currentTimeMillis();
    private RealmList<Player> mItems = new RealmList<>();

    public PlayersContainer() {
    }

    public PlayersContainer(int id, List<Player> items) {
        mId = id;
        mItems.addAll(items);
    }

    @Override
    public List<Player> getItems() {
        return mItems;
    }

    @Override
    public Long getCreationTime() {
        return mCreationTime;
    }
}
