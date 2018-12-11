package com.example.lena.finalapp.presentation.screen.favorite

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.lena.finalapp.R
import com.example.lena.finalapp.databinding.FragmentFavoriteBinding
import com.example.lena.finalapp.presentation.base.BaseMvvmFragment
import com.example.lena.finalapp.presentation.screen.MainRouter

class FavoriteWordsFragment : BaseMvvmFragment<FavoriteViewModel, MainRouter, FragmentFavoriteBinding>() {
    override fun prodiveViewModel(): FavoriteViewModel {
        return ViewModelProviders.of(this)
                .get(FavoriteViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_favorite
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = viewModel.adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerView.setHasFixedSize(true)
    }
}


