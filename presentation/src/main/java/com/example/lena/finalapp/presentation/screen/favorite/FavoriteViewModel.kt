package com.example.lena.finalapp.presentation.screen.favorite

import android.databinding.ObservableField
import android.util.Log
import com.example.domain.usecases.GetWordsUseCase
import com.example.lena.finalapp.presentation.base.BaseViewModel
import com.example.lena.finalapp.presentation.screen.MainRouter
import com.example.lena.finalapp.presentation.screen.favorite.items.WordFavItemAdapter
import com.gmail.superarch.app.App
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class FavoriteViewModel : BaseViewModel<MainRouter>() {

    @Inject
    lateinit var getWordsUseCase: GetWordsUseCase

    var wordPl = ObservableField<String>("")

    var adapter = WordFavItemAdapter()

    init {
        App.appComponent.inject(this)
        var disposable = getWordsUseCase.getAll()?.subscribeBy(
                onNext = {
                    Log.e("aaa", "TranslateViewModel - translated onNext: " + it.toString())
                    adapter.addItems(it)
                    adapter.notifyDataSetChanged()
                },
                onError = {
                    Log.e("aaa", "TranslateViewModel - translated onError: " + it.toString())
                    router?.showError(it)
                })
        addToDisposable(disposable)
    }
}