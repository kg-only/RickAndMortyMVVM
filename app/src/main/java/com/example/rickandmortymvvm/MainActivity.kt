package com.example.rickandmortymvvm

import android.os.Bundle
import com.example.rickandmortymvvm.common.base.BaseActivity
import com.example.rickandmortymvvm.main.ui.RickAndMortyFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(RickAndMortyFragment())
    }
}
