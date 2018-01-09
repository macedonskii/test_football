package com.mad.footballtest.mvp.screens.leaguetable;

import android.os.Parcelable;

import com.mad.footballtest.mvp.presenter.Presenter;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;
import com.mad.footballtest.mvp.view.View;

import java.util.List;

/**
 * Created by mad on 03.01.2018.
 */

public interface Contract {
    interface LeagueTableView extends View{
        void showItems(List<TableItem> tableItems, Parcelable parcelable);

        void showCommandActivity(int id);
    }
    interface LeagueTablePresenter extends Presenter, LeagueTableAdapter.ClickListener {
        void onCreate(int anInt, Parcelable parcelable);
    }
}
