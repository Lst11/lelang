package com.example.lena.finalapp.presentation.screen.translator

import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.example.domain.usecases.GetTranslateUseCase
import com.example.lena.finalapp.presentation.base.BaseViewModel
import com.example.lena.finalapp.presentation.screen.MainRouter
import com.example.lena.finalapp.presentation.screen.translator.items.WordItemAdapter
import com.gmail.superarch.app.App
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class TranslateViewModel : BaseViewModel<MainRouter>() {

    @Inject
    lateinit var getTranslateUseCase: GetTranslateUseCase

    var wordPl = ObservableField<String>("")

    var adapter = WordItemAdapter()

    init {
        App.appComponent.inject(this)
    }

    fun onClickTranslate(v: View) {
        Log.e("aaa", "TranslateViewModel onClickTranslate: " + wordPl.get())
        if (wordPl.get()?.isNotEmpty() == true) {
            getTranslateUseCase.getTranslate(wordPl.get() ?: "")
                    ?.subscribeBy(
                            onNext = {
                                Log.e("aaa", "TranslateViewModel - translated onNext: " + it.toString())
                                adapter.addItems(it.wordRU)
                                adapter.notifyDataSetChanged()
                            },
                            onError = {
                                Log.e("aaa", "TranslateViewModel - translated onError: " + it.toString())
                                router?.showError(it)
                            })
        }
    }

    fun onClickDelete(v: View) {
        Log.e("aaa", "TranslateViewModel onClickDelete")
        wordPl.set("")
        adapter.cleanItems()
    }
}