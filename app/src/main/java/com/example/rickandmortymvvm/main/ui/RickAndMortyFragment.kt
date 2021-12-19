package com.example.rickandmortymvvm.main.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortymvvm.R
import com.example.rickandmortymvvm.adapter.MyAdapter
import com.example.rickandmortymvvm.common.base.BaseFragment
import com.example.rickandmortymvvm.databinding.FragmentRickAndMortyBinding
import com.example.rickandmortymvvm.main.models.ResultHero
import org.koin.androidx.viewmodel.ext.android.viewModel

private lateinit var adapter: MyAdapter
private lateinit var binding: FragmentRickAndMortyBinding

class RickAndMortyFragment : BaseFragment(R.layout.fragment_rick_and_morty) {

    private val rickAndMortyViewModel: RickAndMortyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRickAndMortyBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerSet()

        rickAndMortyViewModel.listLiveData.observe(this, { adapter.setItems(it) })
        rickAndMortyViewModel.loadRickMorty()

    }

    private fun recyclerSet() {
        adapter = MyAdapter(onClick = { startInfoFragment(it) })
        binding.recViewHero.layoutManager = LinearLayoutManager(context)
        binding.recViewHero.adapter = adapter
    }

    private fun startInfoFragment(hero: ResultHero) {
        Log.e("###", "FirstPoint")
        val data = Bundle()
        data.putParcelable("heroes", hero)
        val heroInfo = InfoFragment()
        heroInfo.arguments = data
        changeFragment(heroInfo, R.id.frame_layout)
    }
}