package com.mad.footballtest.mvp.model;


import com.mad.footballtest.App;
import com.mad.footballtest.R;
import com.mad.footballtest.mvp.model.api.ApiInterface;
import com.mad.footballtest.mvp.model.api.ErrorWithMessage;
import com.mad.footballtest.mvp.model.database.Database;
import com.mad.footballtest.mvp.screens.commandplayers.data.Player;
import com.mad.footballtest.mvp.screens.commandplayers.data.response.CommandPlayerMaper;
import com.mad.footballtest.mvp.screens.commandprofile.data.Command;
import com.mad.footballtest.mvp.screens.commandprofile.data.CommandMaper;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.screens.leagueslist.data.response.LeaguesMaper;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;
import com.mad.footballtest.mvp.screens.leaguetable.data.response.TableItemMaper;
import com.mad.footballtest.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by mad on 17.12.2017.
 */

public class ModelImpl implements Model {

    @Inject
    ApiInterface mApi;
    @Inject
    Database mDatabase;
    @Inject
    NetworkUtils mNetworkUtils;

    public ModelImpl() {
        App.getAppGraph().inject(this);
    }

    <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    <T> Observable<T> responseHandler(Response<T> response) {
        if (!response.isSuccessful() || response.body() == null) {
            return Observable.error(new ErrorWithMessage(R.string.error_server_default));
        }
        return Observable.just(response.body());
    }

    @Override
    public Observable<List<LeagueItem>> loadLeagues() {
        return Observable.just(mDatabase)
                .flatMap(Database::getLeagues)
                .switchIfEmpty(
                        mApi.getLeagues()
                                .flatMap(this::responseHandler)
                                .map(new LeaguesMaper())
                                .doOnNext(mDatabase::saveLeagues)
                )
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<TableItem>> getLeagueTable(int leagueId) {
        return Observable.just(leagueId)
                .flatMap(integer -> mDatabase.getTableItems(integer))
                .switchIfEmpty(
                        mApi.getLeagueTable(leagueId)
                                .flatMap(this::responseHandler)
                                .map(new TableItemMaper())
                                .doOnNext(tableItems -> mDatabase.saveTableItems(leagueId, tableItems))

                ).compose(applySchedulers());
    }

    @Override
    public Observable<Command> getCommandData(int commandId) {
        return Observable.just(commandId)
                .flatMap(integer -> mDatabase.getCommand(integer))
                .switchIfEmpty(
                        mApi.getCommandProfile(commandId)
                                .flatMap(this::responseHandler)
                                .map(new CommandMaper())
                                .map(command -> command.setId(commandId))
                                .doOnNext(mDatabase::saveCommand)
                ).compose(applySchedulers());
    }

    @Override
    public Observable<List<Player>> loadCommandPlayers(int commandId) {
        return Observable.just(commandId)
                .flatMap(integer -> mDatabase.getPlayers(integer))
                .switchIfEmpty(
                        mApi.getCommandPlayers(commandId)
                                .flatMap(this::responseHandler)
                                .map(new CommandPlayerMaper())
                                .doOnNext(players -> mDatabase.savePlayers(commandId, players))
                ).compose(applySchedulers());
    }
}
