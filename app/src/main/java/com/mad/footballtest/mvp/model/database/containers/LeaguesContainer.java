package com.mad.footballtest.mvp.model.database.containers;

import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by mad on 09.01.2018.
 */
public class LeaguesContainer extends RealmObject implements ListContainer{

    @PrimaryKey
    protected int mId;
    private Long mCreationTime = System.currentTimeMillis();
    private RealmList<LeagueItem> mItems = new RealmList<>();

    public LeaguesContainer() {
    }

    public LeaguesContainer(int id, List<LeagueItem> items) {
        mId = id;
        mItems.addAll(items);
    }

    @Override
    public List<LeagueItem> getItems() {
        return mItems;
    }

    @Override
    public Long getCreationTime() {
        return mCreationTime;
    }
}
