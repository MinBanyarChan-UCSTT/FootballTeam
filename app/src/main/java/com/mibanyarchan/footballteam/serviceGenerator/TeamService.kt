package com.mibanyarchan.footballteam.serviceGenerator

import com.mibanyarchan.footballteam.constant.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TeamService{
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
    }
