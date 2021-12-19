package com.example.rickandmortymvvm.repository

import com.example.rickandmortymvvm.main.models.ResultHero
import kotlinx.coroutines.flow.Flow

interface HeroLocalRepository {
    suspend fun insertListHeroesLocalRepos(heroes:List<ResultHero>)

    suspend fun getListHeroesRoomLocalRepos(): Flow<List<ResultHero>>
}