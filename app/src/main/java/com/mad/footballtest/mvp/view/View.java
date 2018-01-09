package com.mad.footballtest.mvp.view;

/**
 * Created by mad on 17.12.2017.
 */

public interface View {
    void onError(Throwable throwable);

    void showMessage(int messageId);
}
