package com.example.rickandmortymvvm.interactor

import com.example.rickandmortymvvm.main.models.ResultHero
import com.example.rickandmortymvvm.repository.HeroLocalRepository
import com.example.rickandmortymvvm.repository.HeroRemoteRepository
import kotlinx.coroutines.flow.Flow

class InteractorHeroList(
    private val heroesLocalRepository: HeroLocalRepository,
    private val heroesRemoteRepository: HeroRemoteRepository,
) {
    suspend fun getHeroesFromInteractor(): Flow<List<ResultHero>> {
        return heroesLocalRepository.getListHeroesRoomLocalRepos()
    }

    suspend fun loadHeroesFromInteractor(): List<ResultHero> {
        val heroes = heroesRemoteRepository.loadHeroesFromRemoteRepos()
        heroesLocalRepository.insertListHeroesLocalRepos(heroes)
        return heroes
    }
}