package com.example.rickandmortymvvm.responsemodel
import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("results")
    val results: List<RickAndMortyResponse>
)
