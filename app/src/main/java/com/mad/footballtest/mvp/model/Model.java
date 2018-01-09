package com.mad.footballtest.mvp.model;


import com.mad.footballtest.mvp.screens.commandplayers.data.Player;
import com.mad.footballtest.mvp.screens.commandprofile.data.Command;
import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;
import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mad on 17.12.2017.
 */

public interface Model {

    Observable<List<TableItem>> getLeagueTable(int leagueId);

    Observable<Command> getCommandData(int commandId);

    Observable<List<Player>> loadCommandPlayers(int commandId);

    Observable<List<LeagueItem>> loadLeagues();
}
