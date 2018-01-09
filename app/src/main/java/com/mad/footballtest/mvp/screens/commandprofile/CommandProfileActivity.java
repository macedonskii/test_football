package com.mad.footballtest.mvp.screens.commandprofile;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.mad.footballtest.R;
import com.mad.footballtest.databinding.ActivityCommandDetailsBinding;
import com.mad.footballtest.mvp.screens.commandplayers.CommandPlayersActivity;
import com.mad.footballtest.mvp.screens.commandprofile.data.Command;
import com.mad.footballtest.mvp.view.AbstractActivity;

/**
 * Created by mad on 03.01.2018.
 */

public class CommandProfileActivity extends AbstractActivity implements Contract.CommandProfileView {
    private static final String TAG_DATA = "DATA";
    private Contract.CommandProfilePresenter mPresenter = new CommandProfilePresenter(this);
    private ActivityCommandDetailsBinding mBinding;

    @Override
    public Contract.CommandProfilePresenter getPresenter() {
        return mPresenter;
    }

    public static Intent getIntent(Context context, int id) {
        return new Intent(context, CommandProfileActivity.class).putExtra(TAG_DATA, id);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_command_details);
        mBinding.btnShowTable.setOnClickListener(v -> mPresenter.onClickShowPlayers());
        showBackButton();

        mPresenter.onCreate(savedInstanceState, getIntent().getIntExtra(TAG_DATA,0));
    }

    @Override
    public void showCommandData(Command command) {
        mBinding.tvCommandName.setText(command.getName());
    }

    @Override
    public void showPlayersActivity(int commandId) {
        startActivity(CommandPlayersActivity.getIntent(this, commandId));
    }
}
