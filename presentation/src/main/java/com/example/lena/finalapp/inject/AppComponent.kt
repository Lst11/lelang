package com.gmail.superarch.inject

import com.example.lena.finalapp.presentation.screen.favorite.FavoriteViewModel
import com.example.lena.finalapp.presentation.screen.translator.TranslateViewModel
import com.gmail.superarch.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class])
interface AppComponent {

    fun inject(viewModel: TranslateViewModel)
    fun inject(viewModel: FavoriteViewModel)
}