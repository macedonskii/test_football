package com.mad.footballtest.mvp.screens.leaguetable.data.response;

import com.mad.footballtest.mvp.screens.leaguetable.data.TableItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by mad on 05.01.2018.
 */

public class TableItemMaper implements Function<LeagueTableResponse, List<TableItem>> {

    @Override
    public List<TableItem> apply(LeagueTableResponse leagueTableResponse) throws Exception {
        List<TableItem> output = new ArrayList<>();
        for (CommandData commandData : leagueTableResponse.getCommandData()) {
            output.add(new TableItem(
                    commandData.getId(),
                    commandData.getTeamName(),
                    commandData.getWins(),
                    commandData.getLosses(),
                    commandData.getDraws()
            ));
        }
        return output;
    }
}
