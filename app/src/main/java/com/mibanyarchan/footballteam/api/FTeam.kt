package com.mibanyarchan.footballteam.api

import com.mibanyarchan.footballteam.repository.TeamApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FTeam{
    @GET("/api/v1/json/1/searchteams.php?t=Barcelona")
    fun getTeamDetail() : Call<TeamApiResponse>
  //  @GET("/api/v1/json/1/searchteams.php")
   // fun getTeamDetail(@Path(value = "team")tram:String) :Call<TeamApiResponse>
}