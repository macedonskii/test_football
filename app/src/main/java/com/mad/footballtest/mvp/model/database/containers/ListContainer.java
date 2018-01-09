package com.mad.footballtest.mvp.model.database.containers;

import com.google.gson.Gson;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mad on 09.01.2018.
 */
public interface ListContainer {

    List getItems();

    Long getCreationTime();
}
