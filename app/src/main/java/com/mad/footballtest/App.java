package com.mad.footballtest;

import android.app.Application;


import com.mad.footballtest.di.AppGraph;
import com.mad.footballtest.di.ContextModule;
import com.mad.footballtest.di .DaggerAppGraph;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by mad on 17.12.2017.
 */

public class App extends Application {

    private static AppGraph appGraph;
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build());
        appGraph = DaggerAppGraph.builder().contextModule(new ContextModule(this)).build();
    }

    public static AppGraph getAppGraph() {
        return appGraph;
    }
}
