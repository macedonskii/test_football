package com.mad.footballtest.mvp.model.database.containers;

import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mad on 09.01.2018.
 */

public class TableItemsContainer extends RealmObject implements ListContainer {
    @PrimaryKey
    protected int mId;
    private Long mCreationTime = System.currentTimeMillis();
    private RealmList<TableItem> mItems = new RealmList<>();

    public TableItemsContainer() {
    }

    public TableItemsContainer(int id, List<TableItem> items) {
        mId = id;
        mItems.addAll(items);
    }

    @Override
    public List<TableItem> getItems() {
        return mItems;
    }

    @Override
    public Long getCreationTime() {
        return mCreationTime;
    }
}
