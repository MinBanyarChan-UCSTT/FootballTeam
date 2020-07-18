package com.mibanyarchan.footballteam.repository

import com.mibanyarchan.footballteam.model.TeamItem

data class TeamApiResponse(
    val teams:List<TeamItem>
)