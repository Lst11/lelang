package com.example.lena.finalapp.presentation.screen.translator

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.lena.finalapp.R
import com.example.lena.finalapp.databinding.FragmentTranslateBinding
import com.example.lena.finalapp.presentation.base.BaseMvvmFragment
import com.example.lena.finalapp.presentation.screen.MainRouter

class TranslateFragment : BaseMvvmFragment<TranslateViewModel, MainRouter, FragmentTranslateBinding>() {

    override fun prodiveViewModel(): TranslateViewModel {
        return ViewModelProviders.of(this)
                .get(TranslateViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_translate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = viewModel.adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerView.setHasFixedSize(true)
    }
}


