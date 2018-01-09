package com.mad.footballtest.mvp.model.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mad on 08.05.2017.
 */

public class AuthorizationInterceptor implements Interceptor {


    public AuthorizationInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("X-Auth-Token", "c1fced87b9624809b2b3b35ac9eed8d5")
                .build();
        return chain.proceed(request);
    }
}
