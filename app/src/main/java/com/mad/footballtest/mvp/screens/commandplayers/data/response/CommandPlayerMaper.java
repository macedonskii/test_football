package com.mad.footballtest.mvp.screens.commandplayers.data.response;

import com.mad.footballtest.mvp.screens.commandplayers.data.Player;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by mad on 04.01.2018.
 */

public class CommandPlayerMaper implements Function<CommandPlayersResponse, List<Player>> {

    @Override
    public List<Player> apply(CommandPlayersResponse commandPlayersResponse) throws Exception {
        List<Player> list = new ArrayList<>();
        for (CommandPlayer commandPlayer : commandPlayersResponse.getPlayers()) {
            list.add(new Player(commandPlayer.getName(), commandPlayer.getPosition()));
        }
        return list;
    }
}
