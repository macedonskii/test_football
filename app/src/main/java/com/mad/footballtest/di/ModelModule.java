package com.mad.footballtest.di;

import android.content.Context;


import com.mad.footballtest.mvp.model.api.ApiInterface;
import com.mad.footballtest.mvp.model.api.ApiProvider;
import com.mad.footballtest.mvp.model.database.Database;
import com.mad.footballtest.mvp.model.database.DatabaseImpl;
import com.mad.footballtest.utils.NetworkUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mad on 18.12.2017.
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    public Database provideDatabase(Context context){
        return new DatabaseImpl();
    }

    @Provides
    @Singleton
    public ApiInterface provideApi(){
        return new ApiProvider(ApiInterface.HOST).getApiInterface();
    }

    @Provides
    @Singleton
    public NetworkUtils provideNetworkUtils(Context context){
        return new NetworkUtils(context);
    }
}
