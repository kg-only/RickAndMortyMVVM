package com.example.rickandmortymvvm.repository

import com.example.rickandmortymvvm.main.models.ResultHero

interface HeroRemoteRepository {
    suspend fun loadHeroesFromRemoteRepos(): List<ResultHero>
}