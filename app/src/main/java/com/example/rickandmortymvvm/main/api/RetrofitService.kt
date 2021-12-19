package com.example.rickandmortymvvm.main.api

import com.example.rickandmortymvvm.responsemodel.ResponseApi
import retrofit2.http.GET

interface RetrofitService {
    @GET("character")
   suspend fun getHeroList(): ResponseApi
}