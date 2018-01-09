package com.mad.footballtest.mvp.model;

import android.support.annotation.NonNull;

/**
 * Created by mad on 19.12.2017.
 */

public class DataContainer<T> {
    private T data;
    private int messageId;
    private boolean successful;
    private boolean cached;

    public DataContainer(@NonNull T data) {
        this.data = data;
        successful = true;
        this.cached = cached;
    }

    public DataContainer(int messageId) {
        this.messageId = messageId;
        successful = false;
    }

    public T getData() {
        return data;
    }

    public boolean isCached() {
        return cached;
    }

    public int getMessageId() {
        return messageId;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
