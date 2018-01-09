package com.mad.footballtest.mvp.model.database;


import android.support.design.widget.TabItem;

import com.mad.footballtest.mvp.model.database.containers.*;
import com.mad.footballtest.mvp.model.database.containers.TableItemsContainer;
import com.mad.footballtest.mvp.screens.commandplayers.data.Player;
import com.mad.footballtest.mvp.screens.commandprofile.data.Command;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class DatabaseImpl implements Database {

    private static final long CACHE_LIFETIME = 864000000;
    private static final int DEFAULT_LEAGUE_ID = 0;
    private static final String FIELD_ID = "mId";

    public DatabaseImpl() {
    }

    @Override
    public void saveLeagues(List<LeagueItem> leagueItems) {
        executeTransaction(realm -> realm.copyToRealmOrUpdate(new LeaguesContainer(DEFAULT_LEAGUE_ID, leagueItems)));
    }

    @Override
    public Observable<List<LeagueItem>> getLeagues() {
        return provideObservable(DEFAULT_LEAGUE_ID, LeaguesContainer.class, LeagueItem.class);
    }

    @Override
    public void savePlayers(int commandId, List<Player> players) {
        executeTransaction(realm -> realm.copyToRealmOrUpdate(new PlayersContainer(commandId, players)));
    }

    @Override
    public Observable<List<Player>> getPlayers(int commandId) {
        return provideObservable(commandId, PlayersContainer.class, Player.class);
    }

    @Override
    public void saveTableItems(int leagueId, List<TableItem> tableItems) {
        executeTransaction(realm -> realm.copyToRealmOrUpdate(new TableItemsContainer(leagueId, tableItems)));
    }

    @Override
    public Observable<List<TableItem>> getTableItems(int leagueId) {
        return provideObservable(leagueId, TableItemsContainer.class, TableItem.class);
    }

    @Override
    public void saveCommand(Command command) {
        executeTransaction(realm -> realm.copyToRealmOrUpdate(command));
    }

    @Override
    public Observable<Command> getCommand(int commandId) {
        Command[] arr = new Command[1];
        executeTransaction(realm -> {
            Command command = realm.where(Command.class).equalTo("mId", commandId).findFirst();
            if (command != null && command.getCreationTime() + CACHE_LIFETIME > System.currentTimeMillis()) {
                arr[0] = realm.copyFromRealm(command);
            }
        });
        return arr[0] != null ? Observable.just(arr[0]) : Observable.empty();
    }

    private <T extends RealmObject, E> Observable<List<E>> provideObservable(int id, Class<T> clazz, Class<E> output) {
        List<E> list = new ArrayList();
        executeTransaction(realm -> {
            ListContainer container = (ListContainer) realm.where(clazz).equalTo(FIELD_ID, id).findFirst();
            if (container != null && container.getCreationTime() + CACHE_LIFETIME > System.currentTimeMillis()) {
                list.addAll(realm.copyFromRealm(container.getItems()));
            }
        });
        return list.size() != 0 ? Observable.just(list) : Observable.empty();
    }

    private void executeTransaction(Realm.Transaction transaction) {
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.executeTransaction(transaction);
        defaultInstance.close();
    }

}
