package com.example.rickandmortymvvm.repository

import com.example.rickandmortymvvm.main.api.RetrofitService
import com.example.rickandmortymvvm.main.models.ResultHero

class HeroesRepository(private val api: RetrofitService) : HeroRemoteRepository {
    override suspend fun loadHeroesFromRemoteRepos(): List<ResultHero> {
        val data = api.getHeroList()
        return data.results.map {
            ResultHero(created = it.created,
                episode = it.episode,
                gender = it.gender,
                id = it.id,
                image = it.image,
                name = it.name,
                species = it.species,
                status = it.status,
                type = it.type,
                url = it.url)

        }
    }
}