package com.mad.footballtest.di;



import com.mad.footballtest.mvp.model.Model;
import com.mad.footballtest.mvp.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mad on 18.12.2017.
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    public Model provideModel(){
        return new ModelImpl();
    }
}
