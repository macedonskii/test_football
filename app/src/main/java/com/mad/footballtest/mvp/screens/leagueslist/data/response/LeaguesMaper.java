package com.mad.footballtest.mvp.screens.leagueslist.data.response;

import com.mad.footballtest.mvp.screens.leagueslist.data.LeagueItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by mad on 04.01.2018.
 */

public class LeaguesMaper implements Function<List<LeagueItemResponse>, List<LeagueItem>> {
    @Override
    public List<LeagueItem> apply(List<LeagueItemResponse> leagueItemResponses) throws Exception {
        List<LeagueItem> output = new ArrayList<>();
        for (LeagueItemResponse leagueItemRespons : leagueItemResponses) {
            output.add(new LeagueItem(
                    leagueItemRespons.getId(),
                    leagueItemRespons.getCaption(),
                    leagueItemRespons.getLeague(),
                    leagueItemRespons.getYear(),
                    leagueItemRespons.getCurrentMatchday(),
                    leagueItemRespons.getNumberOfMatchdays(),
                    leagueItemRespons.getNumberOfTeams(),
                    leagueItemRespons.getNumberOfGames()
            ));
        }
        return output;
    }
}
