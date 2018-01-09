package com.mad.footballtest.mvp.model.api;

import com.mad.footballtest.App;
import com.mad.footballtest.R;
import com.mad.footballtest.utils.NetworkUtils;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by mad on 09.01.2018.
 */

public class ConnectionInterceptor implements Interceptor {
    @Inject
    NetworkUtils mNetworkUtils;

    public ConnectionInterceptor() {
        App.getAppGraph().inject(this);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!mNetworkUtils.isConnectedToInternet()) {
            throw new ErrorWithMessage(R.string.error_no_internet);
        }
        return chain.proceed(chain.request());
    }
}
