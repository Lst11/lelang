package com.example.lena.finalapp.presentation.screen.translator

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.lena.finalapp.R
import com.example.lena.finalapp.databinding.FragmentTranslateBinding
import com.example.lena.finalapp.presentation.base.BaseMvvmFragment
import com.example.lena.finalapp.presentation.screen.MainRouter
import com.gmail.superarch.app.App

class TranslateFragment : BaseMvvmFragment<TranslateViewModel, MainRouter, FragmentTranslateBinding>() {

    override fun prodiveViewModel(): TranslateViewModel {
        return ViewModelProviders.of(this)
                .get(TranslateViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_translate
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        App.appComponent.inject(this)
//        super.onCreate(savedInstanceState)
//    }

}


