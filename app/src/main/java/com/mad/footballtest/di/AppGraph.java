package com.mad.footballtest.di;

import com.mad.footballtest.mvp.model.ModelImpl;
import com.mad.footballtest.mvp.model.api.ConnectionInterceptor;
import com.mad.footballtest.mvp.presenter.AbstractPresenter;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mad on 18.12.2017.
 */
@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ContextModule.class})
public interface AppGraph {

    void inject(ModelImpl model);

    void inject(AbstractPresenter abstractPresenter);

    void inject(ConnectionInterceptor connectionInterceptor);

}
