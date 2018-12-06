package com.example.lena.finalapp.presentation.screen.translator

import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.example.domain.usecases.GetTranslateUseCase
import com.example.lena.finalapp.presentation.base.BaseViewModel
import com.example.lena.finalapp.presentation.screen.MainRouter
import com.gmail.superarch.app.App
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class TranslateViewModel : BaseViewModel<MainRouter>() {

    var wordPl = ObservableField<String>("")

    @Inject
    lateinit var getTranslateUseCase: GetTranslateUseCase

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
                            },
                            onError = {
                                Log.e("aaa", "TranslateViewModel - translated onError: " + it.toString())
                            })
        }
    }

    fun onClickDelete(v: View) {
        Log.e("aaa", "TranslateViewModel onClickDelete")
        wordPl.set("")
    }
}