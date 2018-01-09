package com.mad.footballtest.mvp.screens.commandprofile.data;

import io.reactivex.functions.Function;

/**
 * Created by mad on 05.01.2018.
 */

public class CommandMaper implements Function<CommandResponse, Command> {

    @Override
    public Command apply(CommandResponse commandResponse) throws Exception {
        return new Command(
                commandResponse.getName(),
                commandResponse.getCode(),
                commandResponse.getCrestUrl()
        );
    }
}
