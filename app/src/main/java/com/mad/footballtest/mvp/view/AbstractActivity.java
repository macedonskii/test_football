package com.mad.footballtest.mvp.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.mad.footballtest.R;
import com.mad.footballtest.mvp.model.api.ErrorWithMessage;
import com.mad.footballtest.mvp.presenter.Presenter;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


/**
 * Created by mad on 17.12.2017.
 */

public abstract class AbstractActivity extends AppCompatActivity implements View {

    public final String TAG = getClass().getSimpleName();
    public abstract Presenter getPresenter();

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void showBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMessage(int messageId) {
        Toast.makeText(this,messageId, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        ErrorWithMessage errorWithMessage = throwable instanceof ErrorWithMessage ? ((ErrorWithMessage) throwable) : null;
        if (errorWithMessage != null) {
            showMessage(errorWithMessage.getMessageId());
            return;
        }
        if (throwable instanceof IOException) {
            showMessage(R.string.error_no_internet);
            return;
        }
        showMessage(R.string.error_no_reason);

    }
}
