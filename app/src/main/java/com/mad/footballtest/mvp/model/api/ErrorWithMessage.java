package com.mad.footballtest.mvp.model.api;

import java.io.IOException;

import retrofit2.Response;

public class ErrorWithMessage extends IOException {

    private int messageId;

    public ErrorWithMessage(int messageId) {
        this.messageId = messageId;
    }

    public int getMessageId() {
        return messageId;
    }


}
