package com.mad.footballtest.mvp.model.api;


import com.google.gson.JsonObject;
import com.mad.footballtest.mvp.screens.commandplayers.data.response.CommandPlayersResponse;
import com.mad.footballtest.mvp.screens.commandprofile.data.CommandResponse;
import com.mad.footballtest.mvp.screens.leagueslist.data.response.LeagueItemResponse;
import com.mad.footballtest.mvp.screens.leaguetable.data.response.LeagueTableResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    String HOST = "https://api.football-data.org/";


    @GET("v1/soccerseasons/")
    Observable<Response<List<LeagueItemResponse>>> getLeagues();

    @GET("v1/competitions/{id}/leagueTable")
    Observable<Response<LeagueTableResponse>> getLeagueTable(@Path("id") int id);

    @GET("v1/teams/{id}")
    Observable<Response<CommandResponse>> getCommandProfile(@Path("id") int id);

    @GET("v1/teams/{id}/players")
    Observable<Response<CommandPlayersResponse>> getCommandPlayers(@Path("id") int id);


}
