package com.example.rickandmortymvvm.main.db.dbmodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.rickandmortymvvm.main.db.convertors.RoomConvertor

@Entity(tableName = "resultDao")
@TypeConverters(RoomConvertor::class)
data class RickAndMortyEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "episode") val episode: List<String>,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "created") val created: String,

)
