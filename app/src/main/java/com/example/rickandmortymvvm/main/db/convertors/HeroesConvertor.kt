package com.example.rickandmortymvvm.main.db.convertors

import com.example.rickandmortymvvm.main.db.dbmodels.RickAndMortyEntity
import com.example.rickandmortymvvm.main.models.ResultHero

object HeroesConvertor {
    fun toDatabase(heroes: ResultHero): RickAndMortyEntity =
        RickAndMortyEntity(
            id = heroes.id,
            name = heroes.name,
            status = heroes.status,
            species = heroes.species,
            type = heroes.type,
            gender = heroes.gender,
            image =heroes.image,
            episode = heroes.episode,
            url = heroes.url,
            created = heroes.created
        )

    fun fromDatabase(entity: RickAndMortyEntity): ResultHero =
        ResultHero(id = entity.id,
            name = entity.name,
            status = entity.status,
            species = entity.species,
            type = entity.type,
            gender = entity.gender,
            image =entity.image,
            episode = entity.episode,
            url = entity.url,
            created = entity.created
        )
}