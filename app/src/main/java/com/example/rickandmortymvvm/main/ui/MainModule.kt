package com.example.rickandmortymvvm.main.ui

import androidx.room.Room
import com.example.rickandmortymvvm.interactor.InteractorHeroList
import com.example.rickandmortymvvm.main.db.database.RickAndMortyDatabase
import com.example.rickandmortymvvm.repository.HeroLocalRepository
import com.example.rickandmortymvvm.repository.HeroRemoteRepository
import com.example.rickandmortymvvm.repository.HeroesDataBaseRepository
import com.example.rickandmortymvvm.repository.HeroesRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create(): Module = module {
        factory { RickAndMortyViewModel(get()) }

        factory {
            val interactor = InteractorHeroList(get(), get())
            interactor
        } bind InteractorHeroList::class

        single {
            Room.databaseBuilder(get(), RickAndMortyDatabase::class.java, "resultDao")
                .build()
        }
        single { get<RickAndMortyDatabase>().resultDao() }
        single<HeroLocalRepository> { HeroesDataBaseRepository(get()) }
        single<HeroRemoteRepository> { HeroesRepository(get()) }
    }
}