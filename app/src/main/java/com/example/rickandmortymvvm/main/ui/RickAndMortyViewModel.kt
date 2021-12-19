package com.example.rickandmortymvvm.main.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortymvvm.interactor.InteractorHeroList
import com.example.rickandmortymvvm.main.models.ResultHero
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RickAndMortyViewModel(
    private val interactor: InteractorHeroList,
) : ViewModel() {
    val listLiveData = MutableLiveData<List<ResultHero>>()

    init {
        viewModelScope.launch {
            interactor.getHeroesFromInteractor().collect {
                listLiveData.value = it
            }
        }
    }

    fun loadRickMorty() = viewModelScope.launch {
        try {
            interactor.loadHeroesFromInteractor()
        } catch (throwable: Throwable) {
            Log.e("###", "Error process in loadDataHeroes() ", throwable)
        }
    }
}


