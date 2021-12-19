package com.example.rickandmortymvvm.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortymvvm.main.db.dao.Dao
import com.example.rickandmortymvvm.main.db.dbmodels.RickAndMortyEntity

@Database(entities = [RickAndMortyEntity::class], version = 1)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun resultDao(): Dao
}