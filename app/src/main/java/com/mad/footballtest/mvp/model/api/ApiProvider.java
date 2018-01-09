package com.mad.footballtest.mvp.model.api;

import com.google.gson.Gson;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.mad.footballtest.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private String host;
    private ApiInterface apiInterface;

    public ApiProvider(String host) {
        this.host = host;
        createInterface();
    }

    private void createInterface() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(7000, TimeUnit.MILLISECONDS);
        httpClient.connectTimeout(7000, TimeUnit.MILLISECONDS);

        httpClient.addInterceptor(new AuthorizationInterceptor());
        httpClient.addInterceptor(new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .addHeader("version", BuildConfig.VERSION_NAME)
                .build());
        httpClient.addInterceptor(new ConnectionInterceptor());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build());
        apiInterface = builder.build().create(ApiInterface.class);
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
