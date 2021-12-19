package com.example.rickandmortymvvm.repository

import com.example.rickandmortymvvm.main.db.convertors.HeroesConvertor
import com.example.rickandmortymvvm.main.db.dao.Dao
import com.example.rickandmortymvvm.main.models.ResultHero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HeroesDataBaseRepository(private val dao: Dao) : HeroLocalRepository {

    override suspend fun insertListHeroesLocalRepos(heroes: List<ResultHero>) {
        val entities = heroes.map { HeroesConvertor.toDatabase(it) }
        dao.insertAll(entities)
    }

    override suspend fun getListHeroesRoomLocalRepos(): Flow<List<ResultHero>> {
        return dao.getAll().map { list ->
            list.map { HeroesConvertor.fromDatabase(it) }
        }
    }
}