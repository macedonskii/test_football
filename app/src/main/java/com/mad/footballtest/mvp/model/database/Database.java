package com.mad.footballtest.mvp.model.database;


import com.mad.footballtest.mvp.screens.commandplayers.data.Player;
import com.mad.footballtest.mvp.screens.commandprofile.data.Command;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import java.util.List;

import io.reactivex.Observable;


public interface Database {

    void saveLeagues(List<LeagueItem> leagueItems);

    void savePlayers(int commandId, List<Player> players);

    void saveTableItems(int leagueId, List<TableItem> tableItems);

    void saveCommand(Command command);

    Observable<List<LeagueItem>> getLeagues();

    Observable<List<Player>> getPlayers(int commandId);

    Observable<Command> getCommand(int commandId);

    Observable<List<TableItem>> getTableItems(int leagueId);

}
