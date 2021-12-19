package com.example.rickandmortymvvm.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortymvvm.main.db.dbmodels.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM resultDao")
    fun getAll(): Flow<List<RickAndMortyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(resultInsert: List<RickAndMortyEntity>)

}